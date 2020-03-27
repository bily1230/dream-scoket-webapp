package com.dream.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spring.RootConfigTest;
import spring.WebConfigTest;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-29 下午3:28
 **/
@SpringJUnitWebConfig(classes = {RootConfigTest.class, WebConfigTest.class})
public abstract class AbstractController {
    private MockMvc mockMvc;

    @BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    public MockMvc getMockMvc() {
        return mockMvc;
    }
}
