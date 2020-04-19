package com.qingyou.commodityPools.controller;

import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.enityt.CommodityPools;
import com.qingyou.commodityPools.service.GetComListService;
import com.qingyou.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletionService;

@RequestMapping("/comPools")
@CrossOrigin(allowCredentials="true",origins = "http://localhost:9528")
@RestController
public class CommodityController {

    @Autowired
    GetComListService getComListService;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/getList")
    public RestResult getComdity(@RequestBody String postJson, @CookieValue("sessionId") String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        List<CommodityPools> list =new ArrayList<>();
        list=getComListService.getList(postJson,token);
        if(list!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,list,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }

    @RequestMapping("/getStarList")
    public RestResult getComdityWithStar(@RequestBody String postJson,@CookieValue("sessionId") String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        List<CommodityPools> list =new ArrayList<>();
        list=getComListService.getStarList(postJson,token);
        if(list!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,list,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }
    @RequestMapping("/getNumOfCom")
    public RestResult getNumOfCom(@RequestBody String postJson,@CookieValue("sessionId") String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        HashMap<String,Long> map=new HashMap<>();
        map=getComListService.getNum(postJson,token);
        if(map!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,map,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }

    @RequestMapping("/srchcomd")
    public RestResult getComdityWithId(@RequestBody String postJson,@CookieValue("sessionId") String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        if(user==null){
            return new RestResult(500,null,"无效token");
        }else if(user.getId()==-1){
            return new RestResult(504,null,"token失效");
        }
        CommodityPools commodityPools;
        commodityPools=getComListService.getComById(postJson,token);
        if(commodityPools!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,commodityPools,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }
}
