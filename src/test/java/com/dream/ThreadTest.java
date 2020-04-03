package com.dream;

import com.dream.utils.LinstenerB;
import com.dream.utils.ListenerA;
import com.dream.utils.Message;
import com.dream.utils.TaskCenter;
import org.junit.jupiter.api.Test;

/**
 * @program: dream-socket-webapp .
 * @description: 多线程测试 .
 * @author: ning .
 * @create: 2020-04-02 15:19 .
 */
public class ThreadTest {
x
	@Test
	public void publicMessage() {
		TaskCenter taskCenter = new TaskCenter();
		taskCenter.initialize();
		taskCenter.addListener(new ListenerA());
		taskCenter.addListener(new LinstenerB());
		for (int i = 0; i < 1000; i++) {
			String name = "m-" + i;
			Message message = new Message(name);
			taskCenter.publishMessage(message);
			if (i == 900) {
				taskCenter.interrupeTask();
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		TaskCenter.Monitor monitor = taskCenter.getMonitor();
		System.out.println(monitor.getLargeThread());
		System.out.println(monitor.getQueueLength());
		System.out.println(monitor.getCoreThreadSize());

	}
}
