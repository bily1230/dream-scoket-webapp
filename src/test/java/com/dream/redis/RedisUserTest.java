/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis;

import com.dream.AbstractTest;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-21
 */
@ContextConfiguration
public class RedisUserTest extends AbstractTest {
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void testUser() {
	//	assert redisUtils.createUser("testmi1231231231ng", "xiaoming") == 2;
		//assert redisUtils.createUser("testxiaoming", "xiaoming1") == -2;
		assert redisUtils.createStatus(2, "This i11s a new status message", Maps.newHashMap()) == 2;
	}
}

