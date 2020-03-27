package com.dream.service;

import com.dream.AbstractTest;
import com.dream.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-25 下午3:10
 **/


@ContextConfiguration
public class UserServiceTest extends AbstractTest {
    @Autowired
    private UserService userService;

    @Test
    public void getName() {

        List<User> list = userService.getUserList();
        System.out.println(list.size());
    }
}
