/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-21
 */
@Component
public class RedisUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtils.class);

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public long createUser(String login, String name) {
		String llogin = login.toLowerCase();
		RedisLock redisLock = new RedisLock(stringRedisTemplate, llogin);
		if (redisLock.lock()) {
			if (redisTemplate.opsForHash().get("users:", llogin) != null) {
				return -2;
			}
			long id = redisTemplate.opsForValue().increment("user:id");
			Map<String, String> values = Maps.newHashMap();
			values.put("login", login);
			values.put("id", String.valueOf(id));
			values.put("name", name);
			values.put("followers", "0");
			values.put("following", "0");
			values.put("posts", "0");

			redisTemplate.execute(new SessionCallback<List<Object>>() {
				public List<Object> execute(RedisOperations operations) throws DataAccessException {
					operations.multi();
					operations.opsForHash().put("users:", llogin, id);
					operations.opsForHash().putAll("user:" + id, values);
					return operations.exec();
				}
			});
			redisLock.unlock();
			return id;
		}
		return -1;
	}

	public long createStatus(long userId, String message, Map<String, String> data) {


		List<Object> results = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
			public List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForHash().get("user:" + userId, "login");
				operations.opsForValue().increment("status:id");
				return operations.exec();
			}
		});

		String login = (String) results.get(0);
		long statusId = (long) results.get(1);
		if (login == null) {
			return -1;
		}
		if (data == null) {
			data = Maps.newHashMap();
		}
		data.put("message", message);
		data.put("posted", String.valueOf(System.currentTimeMillis()));
		data.put("id", String.valueOf(statusId));
		data.put("uid", String.valueOf(userId));
		data.put("login", login);

		Map<String, String> finalData = data;
		redisTemplate.execute(new SessionCallback<List<Object>>() {
			public List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForHash().putAll("status:" + statusId, finalData);
				return operations.exec();
			}
		});
		redisTemplate.executePipelined(
				new RedisCallback<Long>() {
					public Long doInRedis(RedisConnection connection) throws DataAccessException {
						String rawKey = "user:" + userId;
						String rawfield = "posts";
						return connection.hIncrBy(rawKey.getBytes(), rawfield.getBytes(), 1);
					}
				});
		return statusId;
	}


}

