package com.qingyou.commodityPools.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qingyou.commodityPools.dao.CommodityPoolsDao;
import com.qingyou.commodityPools.enityt.CommodityPools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetComListService {
    static Logger logger = LoggerFactory.getLogger(GetComListService.class);
    @Autowired
    CommodityPoolsDao commodityPoolsDao;

    public List<CommodityPools> getList(String postJson){
        System.out.println("***************************"+postJson+"*******************");
        JSONObject jsonObject = JSON.parseObject(postJson);
        int pageNum=jsonObject.getInteger("pagenum");
        PageHelper.startPage(pageNum, 500);
        List<CommodityPools> list = new ArrayList<>();
        list= commodityPoolsDao.getList();
        return list;
    }

    public List<CommodityPools> getStarList(String postJson){
        JSONObject jsonObject = JSON.parseObject(postJson);
        int pageNum=jsonObject.getInteger("pagenum");
        PageHelper.startPage(pageNum, 500);
        List<CommodityPools> list = new ArrayList<>();
        list= commodityPoolsDao.getStarList();
        return list;
    }

    public CommodityPools getComById(String postJson){
        JSONObject jsonObject = JSON.parseObject(postJson);
        int id=jsonObject.getInteger("id");
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
