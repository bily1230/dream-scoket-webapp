package com.dream.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: dream-socket-webapp .
 * @description: 消息接听者A .
 * @author: ning .
 * @create: 2020-03-27 10:38 .
 */
public class ListenerA implements Listener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ListenerA.class);

	@Override
	public String getName() {
		return "A****";
	}

	@Override
	public void event(Message message) {
		LOGGER.info(message.toString());
		System.out.println(getName() + message.toString());
	}
}
