/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.interceptor;

import com.dream.domain.AccessInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-3-9
 */
@Service
public class Container {
	private static final Logger LOGGER = LoggerFactory.getLogger(Container.class);

	private final BlockingQueue<AccessInfo> queue;

	private AtomicBoolean started;

	private ExecutorService executorService;


	public Container() {
		queue = new LinkedBlockingDeque<AccessInfo>();
		started = new AtomicBoolean();
		Executors.newSingleThreadExecutor();
	}

	public void initialize() {
		start();
	}

	public void start() {
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					AccessInfo accessInfo = queue.take();
					long time = accessInfo.getEndTime() - accessInfo.getStartTime();
					System.out.println("***:" + accessInfo.getMethod() + "----" + time);
				} catch (InterruptedException e) {
					LOGGER.error("thread is interrupt");
				}
			}
		});
	}

	public void stop() {
		executorService.shutdown();
	}

	public void saveInfo(AccessInfo accessInfo){
		try {
			queue.put(accessInfo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



}

