package com.dream.utils;

import com.google.common.collect.Queues;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: dream-socket-webapp .
 * @description: 消息处理中心 .
 * @author: ning .
 * @create: 2020-03-27 10:34 .
 */
public class TaskCenter {

	private final List<Listener> listeners;
	private final BlockingQueue<Message> messageQueue;

	public TaskCenter() {
		listeners = new CopyOnWriteArrayList<>();
		messageQueue = Queues.newArrayBlockingQueue(Integer.MAX_VALUE);
	}



}
