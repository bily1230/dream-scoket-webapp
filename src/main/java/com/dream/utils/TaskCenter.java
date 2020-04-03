package com.dream.utils;

import com.google.common.collect.Queues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: dream-socket-webapp .
 * @description: 消息处理中心 .
 * @author: ning .
 * @create: 2020-03-27 10:34 .
 */
public class TaskCenter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskCenter.class);

	private final List<Listener> listeners;
	private final BlockingQueue<Message> messageQueue;
	private final ExecutorService executor;
	private static Thread taskThread;
	private Monitor monitor;

	public TaskCenter() {
		monitor = new Monitor();
		listeners = new CopyOnWriteArrayList<>();
		messageQueue = Queues.newArrayBlockingQueue(1000);
		executor = new ThreadPoolExecutor(5, 200, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(1000));
	}

	public synchronized void initialize() {
		System.out.println("---initialize---");
		publicCenter();
		System.out.println("+++initialize+++");
	}


	public synchronized void removeListener(Listener listener) {
		this.listeners.remove(listener);
	}

	public synchronized void addListener(Listener listener) {
		this.listeners.add(listener);
	}

	public void publishMessage(Message message) {
		try {
			this.messageQueue.put(message);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void interrupeTask() {
		this.taskThread.interrupt();

	}

	/**
	 * 消息处理中心
	 */
	private synchronized void publicCenter() {
		this.taskThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Message message = messageQueue.take();
						synchronized (listeners) {
							listeners.forEach(l -> executor.execute(new MessageThread(l, message)));
						}
						if (Thread.currentThread().isInterrupted()) {
							System.out.println("************:" + Thread.currentThread().isInterrupted());
						}
					} catch (InterruptedException e) {
						boolean isInterupt = Thread.interrupted();
						System.out.println(isInterupt);
					}
				}
			}
		}, "MessageCenter");
		this.taskThread.start();
	}

	class MessageThread implements Runnable {
		private Message message;
		private Listener listener;

		MessageThread(Listener listener, Message message) {
			this.listener = listener;
			this.message = message;
		}

		@Override
		public void run() {
			listener.event(message);
		}
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public class Monitor {
		public ThreadPoolExecutor getThreadPoolExecutor() {
			return (ThreadPoolExecutor) executor;
		}

		public int getQueueLength() {
			return messageQueue.size();
		}

		public int getMaxThread() {
			return getThreadPoolExecutor().getMaximumPoolSize();
		}

		public int getLargeThread() {
			return getThreadPoolExecutor().getLargestPoolSize();
		}

		public int getCoreThreadSize() {
			return getThreadPoolExecutor().getCorePoolSize();
		}

	}

}
