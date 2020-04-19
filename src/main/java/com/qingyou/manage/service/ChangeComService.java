package com.qingyou.manage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingyou.admin.entity.User;
import com.qingyou.admin.service.TokenService;
import com.qingyou.commodityPools.service.GetComListService;
import com.qingyou.manage.dao.ChangeComDao;
import com.qingyou.manage.dao.OperationsDao;
import com.qingyou.manage.entity.Operations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeComService {
    static Logger logger = LoggerFactory.getLogger(ChangeComService.class);

    @Autowired
    TokenService tokenService;

    @Autowired
    ChangeComDao changeComDao;

    @Autowired
    OperationsDao operationsDao;

    public void changeCom(String postJson,String token){
       User user=new User();
        user=tokenService.checkToken(token);
        JSONObject jsonObject = JSON.parseObject(postJson);
        long comId=Long.valueOf(jsonObject.getString("id"));
        int operations=jsonObject.getInteger("operations");
        Operations operations1=new Operations();
        if(operations==1){//商品下架
            changeComDao.moveOff(comId,user.getId());
            operations1.setOperations("下架商品");
        }else if(operations==0){//商品3
            changeComDao.delCom(comId,user.getId());
            operations1.setOperations("删除商品");
        }else {//商品状态改变
            changeComDao.statusChange(comId,user.getId());
            operations1.setOperations("更改商品标记");
        }
        operations1.setGoodId(comId);
        operations1.setUpdate_By(user.getId());
        try {
            operationsDao.irtOperations(operations1);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
