package com.dream;

import com.dream.service.UserService;
import com.dream.utils.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.RootConfigTest;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-25 下午2:45
 **/
@Exte
@ContextConfiguration(classes = RootConfigTest.class)
public class Test1{
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private UserService userService;

    @Test
    public void getName() {

       // List<User> list = userService.getUserList();
        dateUtils.getName();
        System.out.println(dateUtils.getName());
    }
}
