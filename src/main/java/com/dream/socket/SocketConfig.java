package com.dream.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-26 下午5:21
 **/
@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {

	@Nullable
	private TaskScheduler scheduler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatSocket(), "/chatSocket", "/chatSocket/{}");
	}

	@Bean
	@Nullable
	public TaskScheduler defaultSockJsTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolScheduler = new ThreadPoolTaskScheduler();
		threadPoolScheduler.setThreadNamePrefix("SockJS-");
		threadPoolScheduler.setPoolSize(Runtime.getRuntime().availableProcessors());
		threadPoolScheduler.setRemoveOnCancelPolicy(true);
		this.scheduler = threadPoolScheduler;
		return this.scheduler;
	}

	@Bean
	public ChatSocket chatSocket() {
		return new ChatSocket();
	}
}
