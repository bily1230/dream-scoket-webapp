package com.dream.controller;

import com.dream.domain.User;
import com.dream.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-10 下午4:05
 **/
@Api(value = "UserController|用户注册类")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户")
    public User create(User user) {
        return userService.createUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获取用户信息")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "username", required = true, dataType = "String"))
    public User getUserByName(@RequestParam String username) {
        return userService.findUserByUserName(username);
    }


}
