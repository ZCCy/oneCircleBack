package com.qingyou.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingyou.admin.dao.UserDao;
import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.LoginService;
import com.qingyou.admin.service.TokenService;
import com.qingyou.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

@CrossOrigin(allowCredentials="true",origins = "http://localhost:9528")
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public RestResult login (@RequestBody String postJson, HttpServletResponse response) {
        System.out.println(postJson);
        User user=loginService.login(postJson);

        if(user.getMsg().equals("密码错误")){
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"用户或密码错误");
        }else if(user.getMsg().equals("没有此用户")){
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"没有此用户");
        }else if(user.getId()==-1){
            return new RestResult(504,user,"cookie失效");
        }
        else{
            Cookie cookie =new Cookie("sessionId",user.getMsg());
            response.addCookie(cookie);
            return new RestResult(RestResult.STATUS_SUCCESS,user,"登陆成功");
        }
    }

    @RequestMapping("/varcookie")
    public RestResult varCookie(@CookieValue("sessionId") String token) {
        User user = tokenService.checkToken(token);
        if (user.getId() == -1) {
            return new RestResult(504, user, "cookie失效");
        } else {
            return new RestResult(200, null, "cookie未过期");
        }
    }
}
