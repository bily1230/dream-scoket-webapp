package com.dream;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import spring.RootConfigTest;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-26 上午10:17
 **/

@SpringJUnitConfig(RootConfigTest.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfigTest.class})
public class AbstractTest {
}
