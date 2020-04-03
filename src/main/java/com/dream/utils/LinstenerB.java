package com.dream.utils;

/**
 * @program: dream-socket-webapp .
 * @description: 监听者B .
 * @author: ning .
 * @create: 2020-04-02 16:48 .
 */
public class LinstenerB implements Listener {
	@Override
	public String getName() {
		return "B****";
	}

	@Override
	public void event(Message message) {
		System.out.println(getName() + message.toString());
	}
}
