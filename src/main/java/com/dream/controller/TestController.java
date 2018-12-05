package com.dream.controller;

import com.dream.domain.User;
import com.dream.repository.UserInterface;
import com.dream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class TestController {
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private UserRepository userRepository;
   @ResponseBody
   @RequestMapping(value="/home" ,method = RequestMethod.GET)
    public String readWord(){


            User user1 = userRepository.findUser();
            if(user1!=null){
                return user1.getUsername();
            }
            return "no data";
        }

}
