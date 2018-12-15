package com.dream.service.impl;

import com.dream.domain.User;
import com.dream.repository.UserInterface;
import com.dream.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:07
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInterface userInterface;


    @Override
    public List<User> getUserList() {
        Iterable<User> iterable = userInterface.findAll();
        List<User> users = Lists.newArrayList(iterable);
        return users;
    }

    @Override
    public User findUserByUserName(String name) {
        return userInterface.findUserByUsername(name);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userInterface.save(user);
    }
}
