/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis;

import com.dream.AbstractTest;
import com.dream.redis.message.PublishMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-13
 */
@ContextConfiguration
public class MessageTest extends AbstractTest {
	@Autowired
	private PublishMessage publishMessage;

	@Test
	public void sendMessage() {
		String channel = "channel";
		String mesage = "Hello yyyy Message";
		publishMessage.send(channel, mesage);
	}
}

