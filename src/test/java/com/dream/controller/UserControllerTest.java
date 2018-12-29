package com.dream.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-29 下午3:40
 **/
public class UserControllerTest extends AbstractController {

    @Test
    void getUser() throws Exception {
        getMockMvc().perform(get("/user/getUserByName?username=ningbin")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("ningbin"));

    }
}
