package com.qingyou.admin.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingyou.admin.dao.UserDao;
import com.qingyou.admin.entity.User;
import com.qingyou.commodityPools.service.GetComListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class LoginService {
    static Logger logger = LoggerFactory.getLogger(LoginService.class);
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
        try {
            user = userDao.foudUserByUsername(username);
        } catch (Exception e){
            logger.error(e.getMessage());
            user.setMsg("没有此用户");
            return user;
        }
        if(user==null){
            user = new User();
            user.msg="没有此用户";
            return user;
        }else if(!user.getPassword().equals(password)){
            user.msg="密码错误";
        }else{
            user.msg=tokenService.getToken(user);
        }
        return user;
    }
}
