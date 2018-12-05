package com.dream.security;

import com.dream.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:29
 **/
public class UserDetailsServiceSecurity implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceSecurity(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByName(userName);
        if (null != user) {
            return user;
        }
        throw new UsernameNotFoundException("User name" + userName + "not find");
    }
}
