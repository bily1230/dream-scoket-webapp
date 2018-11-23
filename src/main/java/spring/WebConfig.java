package spring;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by ning on 2017/8/20.
 */
//@Configuration注解表明这个类是一个配置类
@Configuration
@EnableWebMvc
@ComponentScan("com.dream")
public class WebConfig extends WebMvcConfigurerAdapter{
	



}

