package com.dream;

import com.dream.domain.User;
import com.dream.service.UserService;
import com.dream.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.RootConfigTest;
import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-25 下午2:45
 **/
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfigTest.class)
public class Test1{
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private UserService userService;

    @Test
    public void getName() {

        List<User> list = userService.getUserList();
        System.out.println(list.size());
    }
}
