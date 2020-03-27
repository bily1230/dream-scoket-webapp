package com.dream.security;

import com.dream.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-10 下午4:40
 **/
@Service
public class UserServiceSecurity {
    @Autowired
    UserInterface userInterface;

    @Transactional
    public User finadUserByUserName(String userName) {
        com.dream.domain.User user = userInterface.findUserByUsername(userName);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(userName, "admin", grantedAuthorities);

    }
}
