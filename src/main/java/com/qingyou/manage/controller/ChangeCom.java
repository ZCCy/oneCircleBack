package com.qingyou.manage.controller;

import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.service.GetComListService;
import com.qingyou.manage.service.ChangeComService;
import com.qingyou.utils.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/manag")
@CrossOrigin(allowCredentials="true",origins = "http://localhost:9528")
@RestController
public class ChangeCom {
    static Logger logger = LoggerFactory.getLogger(ChangeCom.class);
    @Autowired
    ChangeComService changeComService;
    @Autowired
    TokenService tokenService;

    @RequestMapping("/comstatus")
    public RestResult getOperation(@RequestBody String postJson, @CookieValue("sessionId") String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        try {
            changeComService.changeCom(postJson, token);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new RestResult(RestResult.STATUS_OTHERS,null,"操作失败");
        }
       return new RestResult(RestResult.STATUS_SUCCESS,null,"修改成功");
    }
}
