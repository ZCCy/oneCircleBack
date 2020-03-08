package com.qingyou.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.qingyou.admin.dao.UserDao;
import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.LoginService;
import com.qingyou.admin.service.TokenService;
import com.qingyou.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public RestResult login (@RequestBody String postJson, HttpServletResponse response) {
        User user=loginService.login(postJson);
        if(user.getMsg().equals("用户或密码错误")){
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"用户或密码错误");
        }else if(user.getMsg().equals("没有此用户")){
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"没有此用户");
        }else{
            Cookie cookie=new Cookie(user.getUsername(),user.getMsg());
            response.addCookie(cookie);
            return new RestResult(RestResult.STATUS_SUCCESS,user,"登陆成功");
        }
    }

}
