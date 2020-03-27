/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-13
 */
public class DefaultMessageDelegate implements MessageDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageDelegate.class);

	@Override
	public void handleMessage(String message) {
		System.out.println("x--------------------");
		System.out.println(message);
		System.out.println("x--------------------");
		LOGGER.info("yyyy" + message);
	}

	@Override
	public void handleMessage(Map message) {
		System.out.println("y--------------------");
		System.out.println(message);
		System.out.println("y--------------------");
		LOGGER.info("yyyy" + message);
	}

	@Override
	public void handleMessage(byte[] message) {
		System.out.println("z--------------------");
		System.out.println(message);
		System.out.println("z--------------------");
		LOGGER.info("yyyy" + message);
	}


}

