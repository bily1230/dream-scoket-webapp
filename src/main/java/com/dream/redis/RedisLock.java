/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * redis实现一些简单的锁.
 *
 * @author nb
 * @date 19-6-20
 */

public class RedisLock {

	private final static int EXPIRE_TIME = 30;

	private final static long TIME_OUT = 100;
	final Random random = new Random();
	private volatile boolean isLocked = Boolean.FALSE;
	private int expireTime = EXPIRE_TIME;
	private long timeOut = TIME_OUT;
	private String lockKey;
	private long expires = 0;

	private StringRedisTemplate redisTemplate;


	public RedisLock(StringRedisTemplate redisTemplate, String lockKey) {
		this.redisTemplate = redisTemplate;
		this.lockKey = lockKey;


	}


	public boolean lock() {
		long endTime = System.nanoTime() + timeOut * 1000000;

		while (System.nanoTime() < endTime) {
			expires = System.currentTimeMillis() + expireTime + 1;
			String expiresStr = String.valueOf(expires); //锁到期时间
			if (redisTemplate.opsForValue().setIfAbsent(this.lockKey, expiresStr)) {
				redisTemplate.expire(lockKey, expireTime, TimeUnit.SECONDS);
				this.isLocked = Boolean.TRUE;
				break;
			}
			String currentValueStr = redisTemplate.opsForValue().get(lockKey);
			if (StringUtils.isNotBlank(currentValueStr) && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
				String oldValueStr = redisTemplate.opsForValue().getAndSet(lockKey, expiresStr);
				if (StringUtils.isNotBlank(oldValueStr) && oldValueStr.endsWith(currentValueStr)) {
					this.isLocked = Boolean.TRUE;
					break;
				}
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				Thread.interrupted();
			}
		}


		return this.isLocked;
	}

	public void unlock() {
		if (this.isLocked && expires > System.currentTimeMillis()) {
			redisTemplate.delete(this.lockKey);
		}
	}
}

