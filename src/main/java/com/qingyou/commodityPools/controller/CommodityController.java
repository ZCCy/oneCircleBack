package com.qingyou.commodityPools.controller;

import com.qingyou.commodityPools.enityt.CommodityPools;
import com.qingyou.commodityPools.service.GetComListService;
import com.qingyou.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;

@RequestMapping("/comPools")
@CrossOrigin(origins = "*")
@RestController
public class CommodityController {

    @Autowired
    GetComListService getComListService;
    @RequestMapping("/getList")
    public RestResult getComdity(@RequestBody String postJson,@RequestHeader(name="authKey") String token) {
        System.out.println(token);
        List<CommodityPools> list =new ArrayList<>();
        list=getComListService.getList(postJson);
        if(list!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,list,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }

    @RequestMapping("/getStarList")
    public RestResult getComdityWithStar(@RequestBody String postJson,@RequestHeader(name="authKey") String token) {
        System.out.println(token);
        List<CommodityPools> list =new ArrayList<>();
        list=getComListService.getStarList(postJson);
        if(list!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,list,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }

    @RequestMapping("/srchcomd")
    public RestResult getComdityWithId(@RequestBody String postJson,@RequestHeader(name="authKey") String token) {
        System.out.println(token);
        CommodityPools commodityPools;
        commodityPools=getComListService.getComById(postJson);
        if(commodityPools!=null){
            return new RestResult(RestResult.STATUS_SUCCESS,commodityPools,"成功");
        }else{
            return new RestResult(RestResult.STATUS_OTHERS,null,"获取失败");
        }
    }
}
