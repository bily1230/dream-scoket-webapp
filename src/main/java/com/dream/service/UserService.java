package com.dream.service;


import com.dream.domain.User;

import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:05
 **/
public interface UserService {

    List<User> getUserList();

    User findUserByUserName(String name);

    com.dream.domain.User createUser(com.dream.domain.User user);
}
