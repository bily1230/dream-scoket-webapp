/*
 * Project:dream-socket-webapp
 * Copyright 2004-2019 Homolo Co., Ltd. All rights reserved.
 */
package com.dream.redis;

import com.dream.redis.message.DefaultMessageDelegate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

import static org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig;

/**
 * redis学习类.
 *
 * @author nb
 * @date 19-6-13
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Autowired
	LettuceConnectionFactory connectionFactory;

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
		return template;
	}


	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		// 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
		Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		serializer.setObjectMapper(mapper);
		redisTemplate.setValueSerializer(serializer);
		redisTemplate.setHashValueSerializer(serializer);
		// 使用StringRedisSerializer来序列化和反序列化redis的key值
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}


	@Bean
	public CacheManager cacheManager() {
		// 生成一个默认配置，通过config对象即可对缓存进行自定义配置
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		// 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer(Object.class);
		// 配置序列化
		RedisCacheConfiguration config = defaultCacheConfig();
		config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer));
		config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
		// 设置缓存的默认过期时间
		config.entryTtl(Duration.ofMinutes(1));
		// 不缓存空值
		config.disableCachingNullValues();
		RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory).cacheDefaults(config).build();
		return cacheManager;
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer sb = new StringBuffer();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	/**
	 * 发布订阅.
	 *
	 * @param
	 * @return com.dream.redis.message.DefaultMessageDelegate
	 */
	@Bean
	public DefaultMessageDelegate defaultMessageDelegate() {
		return new DefaultMessageDelegate();
	}

	@Bean
	public MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(defaultMessageDelegate());
	}

	@Bean
	public ChannelTopic channelTopic() {
		return new ChannelTopic("channel");
	}


	@Bean
	public RedisMessageListenerContainer redisContainer(MessageListenerAdapter messageListener) {
		RedisMessageListenerContainer redisContainer = new RedisMessageListenerContainer();
		redisContainer.setConnectionFactory(connectionFactory);
		redisContainer.addMessageListener(messageListener(), channelTopic());
		return redisContainer;
	}
}

