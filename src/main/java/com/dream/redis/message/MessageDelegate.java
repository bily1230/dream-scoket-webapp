/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis.message;

import java.io.Serializable;
import java.util.Map;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-13
 */
public interface MessageDelegate {
	void handleMessage(String message);

	void handleMessage(Map message);

	void handleMessage(byte[] message);

	/*void handleMessage(Serializable message);

	// pass the channel/pattern as well
	void handleMessage(Serializable message, String channel);*/
}