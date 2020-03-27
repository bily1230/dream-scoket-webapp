/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-13
 */
@Component
public class PublishMessage {
	@Autowired
	private RedisTemplate redisTemplate;

	public void send(String channel, Object message) {
		redisTemplate.convertAndSend(channel, message);

	}

}

