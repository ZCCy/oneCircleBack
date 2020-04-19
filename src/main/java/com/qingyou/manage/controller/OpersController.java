package com.qingyou.manage.controller;

import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.enityt.CommodityPools;
import com.qingyou.manage.entity.Operations;
import com.qingyou.manage.service.OperationsService;
import com.qingyou.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/operation")
@CrossOrigin(allowCredentials="true",origins = "http://localhost:9528")
@RestController
public class OpersController {

    @Autowired
    OperationsService operationsService;
    @Autowired
    TokenService tokenService;

    @RequestMapping("/gethistory")
    public RestResult getOperation(@RequestBody String postJson, @CookieValue("sessionId") String token) throws ValidationException {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        List<Operations> list =new ArrayList<>();
        list=operationsService.getList(postJson,token);
        if(list==null){
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }else {
            return new RestResult(RestResult.STATUS_SUCCESS,list,"获取成功");
        }
    }
}
