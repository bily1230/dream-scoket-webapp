package com.dream.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-11 下午1:39
 **/
@Controller
@RequestMapping(value = "/system")
@Api(value = "System|系统配置")
public class SystemController {

    @ResponseBody
    @RequestMapping(value="/csrf", method = RequestMethod.GET)
    @ApiOperation(value = "获取csrfToken")
    public Object csrf(HttpServletRequest request){
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if(csrfToken!=null){
            Map<String, String> map = Maps.newHashMap();
            map.put("name", csrfToken.getParameterName());
            map.put("token", csrfToken.getToken());
            return map;
        }
        return "";
    }
}
