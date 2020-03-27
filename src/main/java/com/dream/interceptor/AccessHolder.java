/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.interceptor;

import com.dream.domain.AccessInfo;
import org.springframework.stereotype.Service;

/**
 * 记录访问数据.
 *
 * @author nb
 * @date 19-1-25
 */
@Service
public class AccessHolder {
	private static ThreadLocal<AccessInfo> access = new ThreadLocal<AccessInfo>();

	public static AccessInfo getAccessInfo() {
		return access.get();
	}

	public static void startAccessInfo(AccessInfo accessInfo) {
		access.set(accessInfo);
	}

}

