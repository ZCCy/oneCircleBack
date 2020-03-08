package com.qingyou.admin.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingyou.admin.dao.UserDao;
import com.qingyou.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;
    @Autowired
    TokenService tokenService;
    public User login(String psotJson){
        String token= null;
        JSONObject jsonObject = JSON.parseObject(psotJson);
        User user = new User();
        String username=jsonObject.getString("username");
        String password=jsonObject.getString("password");
        user=userDao.foudUserByUsername(username);
        if(!user.getPassword().equals(password)){
            user.msg="用户或密码错误";
        }else if(user==null){
            user = new User();
            user.msg="没有此用户";
        }else{
            user.msg=tokenService.getToken(user);
        }
        return user;
    }
}
