package spring;

import com.dream.redis.RedisConfig;
import com.dream.session.SessionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-23 下午8:33
 **/
@Configuration
@Import({JpaConfiguration.class, SecurityConfig.class, SessionConfig.class, RedisConfig.class})
@ComponentScan(basePackages = {"com.dream"}, excludeFilters =
		{@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
	@Bean
	public DataSource dataSource() throws NamingException {

		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("jdbc/MySQL");
		factory.setResourceRef(true);
		factory.setProxyInterface(javax.sql.DataSource.class);
		factory.afterPropertiesSet();
		return (DataSource) factory.getObject();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
