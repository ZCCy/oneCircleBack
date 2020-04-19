package com.qingyou.manage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qingyou.admin.controller.LoginController;
import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.service.GetComListService;
import com.qingyou.manage.dao.OperationsDao;
import com.qingyou.manage.entity.Operations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperationsService {
    static Logger logger = LoggerFactory.getLogger(OperationsService.class);

    @Autowired
    OperationsDao operationsDao;
    @Autowired
    TokenService tokenService;
    @Autowired
    LoginController loginController;

    public List<Operations> getList(String postJson, String token) {
        User user=new User();
        user=tokenService.checkToken(token);
        List<Operations> list =new ArrayList<>();
        JSONObject jsonObject = JSON.parseObject(postJson);
        int pageNum=jsonObject.getInteger("pagenum");
        PageHelper.startPage(pageNum, 500);
        try {
            list=operationsDao.getOperationsList();
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
        return list;
    }

    public void addNewOperations(String operations,long update_id, String token){
        Operations operations1=new Operations();
        operations1.setUpdate_By(update_id);
        operations1.setOperations(operations);
        try{
            operationsDao.irtOperations(operations1);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
