package com.dream.controller;

import com.dream.domain.User;
import com.dream.repository.UserRepository;
import com.dream.repository.UserTemplateRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.NamingException;
import java.sql.SQLException;

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
    @Autowired
    private UserTemplateRepository userTemplateRepository;
   @ResponseBody
   @RequestMapping(value="/home" ,method = RequestMethod.GET)
    public String readWord(){
        User user1 = new User();
        user1.setAge("12");
        user1.setName("22");
        user1.setId("0000");
       userTemplateRepository.addUser(user1);

            User user = userRepository.findUser();
            String name = "";
            if(user !=null){
                name = user.getName();
            }
            return name;
        }

}
