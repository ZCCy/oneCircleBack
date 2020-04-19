package com.qingyou.commodityPools.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.dao.CommodityPoolsDao;
import com.qingyou.commodityPools.enityt.CommodityPools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GetComListService {
    static Logger logger = LoggerFactory.getLogger(GetComListService.class);
    @Autowired
    CommodityPoolsDao commodityPoolsDao;

    @Autowired
    TokenService tokenService;

    public List<CommodityPools> getList(String postJson,String token)  {
        tokenService.checkToken(token);
        JSONObject jsonObject = JSON.parseObject(postJson);
        int pageNum=jsonObject.getInteger("pagenum");
        PageHelper.startPage(pageNum, 500);
        List<CommodityPools> list = new ArrayList<>();
        list= commodityPoolsDao.getList();
        return list;
    }

    public List<CommodityPools> getStarList(String postJson,String token)  {
        tokenService.checkToken(token);
        JSONObject jsonObject = JSON.parseObject(postJson);
        int pageNum=jsonObject.getInteger("pagenum");
        PageHelper.startPage(pageNum, 500);
        List<CommodityPools> list = new ArrayList<>();
        list= commodityPoolsDao.getStarList();
        return list;
    }

    public HashMap<String,Long> getNum(String postJson,String token){
        tokenService.checkToken(token);
        HashMap<String,Long> map =new HashMap<>();
        List<CommodityPools> list = new ArrayList<>();
        list= commodityPoolsDao.getList();
        map.put("总商品数",(long)list.size());
        list= commodityPoolsDao.getStarList();
        map.put("标记商品数",(long)list.size());
        list=commodityPoolsDao.getDownList();
        map.put("已下架商品总数",(long)list.size());
        return map;
    }

    public CommodityPools getComById(String postJson,String token) {
        tokenService.checkToken(token);
        JSONObject jsonObject = JSON.parseObject(postJson);
        int id=Integer.valueOf(jsonObject.getString("id"));
        CommodityPools commodityPools=null;
        try {
            commodityPools = commodityPoolsDao.srchById(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
        return commodityPools;
    }
}
