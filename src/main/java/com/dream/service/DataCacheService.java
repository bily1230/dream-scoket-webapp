/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.service;

import com.dream.domain.DataCache;

/**
 * 类描述.
 *
 * @author nb
 * @date 19-6-14
 */
public interface DataCacheService {
	DataCache findDataCacheById(Integer id);

	DataCache createDataCache(DataCache dataCache);

	void deleteDataCache(Integer id);
}