package com.dream.utils;

/**
 * @program: dream-socket-webapp .
 * @description: 监听者 .
 * @author: ning .
 * @create: 2020-03-27 10:35 .
 */
public interface Listener {
	public String getName();
	public void event(Message message);
}
