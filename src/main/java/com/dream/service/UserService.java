package com.dream.service;


import org.springframework.security.core.userdetails.User;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:05
 **/
public interface UserService {

    User findUserByName(String name);
}
