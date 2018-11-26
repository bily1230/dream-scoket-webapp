package com.dream.controller;

import com.dream.domain.User;
import com.dream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-23 下午8:48
 **/
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;
   @ResponseBody
   @RequestMapping(value="/home" ,method = RequestMethod.GET)
    public String readWord(){



            User user = userRepository.findUser();
            String name = "";
            if(user !=null){
                name = user.getName();
            }
            return name;
        }

}
