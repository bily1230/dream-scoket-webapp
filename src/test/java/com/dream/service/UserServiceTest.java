package com.dream.service;

import com.dream.Test1;
import com.dream.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-25 下午3:10
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration
public class UserServiceTest extends Test1 {
    @Autowired
    private UserService userService;
    @Test
    public void getName() {

        List<User> list = userService.getUserList();
        System.out.println(list.size()    );
    }
}
