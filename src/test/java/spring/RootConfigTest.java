package spring;

import com.dream.redis.RedisConfig;
import com.dream.session.SessionConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-25 下午3:45
 **/
@Configuration
@ComponentScan({"com.dream.service", "com.dream.redis", "com.dream.controller", "com.dream.repository", "com.dream.domain", "com.dream.utils"})
@Import({JpaConfiguration.class, RedisConfig.class, SessionConfig.class})
public class RootConfigTest {
	@Bean
	public DataSource dataSource() throws NamingException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://47.98.251.14:3306/dream?autoReconnect=true");
		ds.setUsername("admin");
		ds.setPassword("303admin");
		return ds;
	}

}
