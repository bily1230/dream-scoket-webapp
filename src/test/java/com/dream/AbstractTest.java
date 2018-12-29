package com.dream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.RootConfigTest;
import spring.WebConfig;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-26 上午10:17
 **/

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(RootConfigTest.class)
@ContextConfiguration(classes = {RootConfigTest.class})
public class AbstractTest {
}
