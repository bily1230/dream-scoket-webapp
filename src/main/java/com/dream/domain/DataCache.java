/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 缓存测试类.
 *
 * @author nb
 * @date 19-6-14
 */
@Table(name = "DataCache")
@Entity
public class DataCache implements Serializable {

	private static final long serialVersionUID = 4638780382816138217L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String name;
	private String data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}

