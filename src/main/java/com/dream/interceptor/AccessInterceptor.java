/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.interceptor;


import com.dream.domain.AccessInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接口拦截器.
 *
 * @author nb
 * @date 19-1-25
 */
@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessInterceptor.class);

	@Autowired
	private Container container;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			AccessInfo accessInfo = new AccessInfo();
			accessInfo.setClassName(handlerMethod.getClass().getName());
			accessInfo.setMethod(handlerMethod.getMethod().getName());
			accessInfo.setStartTime(System.currentTimeMillis());
			AccessHolder.startAccessInfo(accessInfo);

		}
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   @Nullable ModelAndView modelAndView) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
								@Nullable Exception ex) throws Exception {

		AccessInfo accessInfo = AccessHolder.getAccessInfo();
		accessInfo.setEndTime(System.currentTimeMillis());
		long time = accessInfo.getEndTime() - accessInfo.getStartTime();
		container.saveInfo(accessInfo);
	}
}

