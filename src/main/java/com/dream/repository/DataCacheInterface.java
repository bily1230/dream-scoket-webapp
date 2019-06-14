/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.repository;

import com.dream.domain.DataCache;
import org.springframework.data.repository.CrudRepository;

/**
 * JPA.
 *
 * @author nb
 * @date 19-6-14
 */
public interface DataCacheInterface extends CrudRepository<DataCache, Integer> {
}