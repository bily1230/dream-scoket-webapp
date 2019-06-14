/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.service.impl;

import com.dream.domain.DataCache;
import com.dream.repository.DataCacheInterface;
import com.dream.service.DataCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-14
 */
@Service
public class DataCacheServiceTest implements DataCacheService {
	@Autowired
	DataCacheInterface dataCacheInterface;

	@Override
	@Cacheable(cacheNames = "dataCache", key = "#id")
	public DataCache findDataCacheById(Integer id) {
		return dataCacheInterface.findOne(id);
	}

	@Override
	public DataCache createDataCache(DataCache dataCache) {
		return dataCacheInterface.save(dataCache);
	}

	@Override
	@CacheEvict(cacheNames = "dataCache", key = "#id")
	public void deleteDataCache(Integer id) {
		dataCacheInterface.delete(id);
	}
}

