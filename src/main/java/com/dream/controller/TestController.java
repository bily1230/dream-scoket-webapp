package com.dream.controller;

import com.dream.domain.User;
import com.dream.repository.UserInterface;
import com.dream.repository.UserRepository;
import com.dream.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-11-23 下午8:48
 **/
@Controller
@RequestMapping(value = "/test")
@Api(tags = "swagger 测试类")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", defaultValue = "小明", required = false), @ApiImplicitParam(name = "age", defaultValue = "王三", required = false)})
    public ModelAndView getUser() {

        User user = userService.findUserByUserName("ningbin");
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("user", user);
        return modelAndView;

    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", required = true), @ApiImplicitParam(name = "password", required = true)})
    public User createUser(User user) {
        return userService.createUser(user);
    }

}
