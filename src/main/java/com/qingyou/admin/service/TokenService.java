package com.qingyou.admin.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.qingyou.admin.dao.UserDao;
import com.qingyou.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Autowired
    UserDao userDao;

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 1000*60*5;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public User checkToken(String token)  {
        System.out.println("000");
        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        long userId;
        try {
            System.out.println(token);
            userId=Long.parseLong(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException j) {
            throw new RuntimeException("无效token");
        }
        User user = null;
        user=userDao.foundUserById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            User user1 = new User();
            user1.setId(-1);
            return user1;
        }
        return user;
    }
}