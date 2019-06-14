/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.service;

import com.dream.AbstractTest;
import com.dream.domain.DataCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-14
 */
@ContextConfiguration
public class DataCacheServiceTest extends AbstractTest {
	@Autowired
	private DataCacheService dataCacheService;

	@Test
	public void addData() {
		DataCache dataCache = new DataCache();
		dataCache.setData("huangxuewen");
		dataCache.setName("lisi");
		dataCacheService.createDataCache(dataCache);
	}

	@Test
	public void getData() {
		DataCache dataCache = dataCacheService.findDataCacheById(3);
		System.out.println(dataCache.getData());

	}

	@Test
	public void deleteData() {
		dataCacheService.deleteDataCache(3);
	}


}

