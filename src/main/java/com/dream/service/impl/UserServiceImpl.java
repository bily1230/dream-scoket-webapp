package com.dream.service.impl;

import com.dream.repository.UserInterface;
import com.dream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public User findUserByName(String userName) {
       // com.dream.domain.User user = userInterface.findUserByUsername(userName);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(userName, "admin", grantedAuthorities);

    }
}
