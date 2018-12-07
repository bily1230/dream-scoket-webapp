package com.dream.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisShardInfo;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-7 上午9:49
 **/
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
    @Bean
    public JedisConnectionFactory sessionConnectionFactory() {
        JedisShardInfo jeJedisShardInfo = new JedisShardInfo("47.98.251.14", 6379);
        jeJedisShardInfo.setConnectionTimeout(1000);
        return new JedisConnectionFactory(jeJedisShardInfo);
    }
}
