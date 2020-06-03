package com.qingyou.threePart.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.FeedBackMsg;
import com.qingyou.threePart.repository.FeedBackMapper;
import com.qingyou.threePart.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    public PageInfo getList(int pageNum, int pageSize, String state){
        PageHelper.startPage(pageNum,pageSize);
        List<FeedBackMsg> list=feedBackMapper.getByState(state);
        return new PageInfo<>(list);
     }
     @Override
    public FeedBackMsg getFeedBack(String userid){
        return feedBackMapper.getOne(userid);
     }
    @Override
    public int getPageNum(FeedBackMsg s){
        List list =feedBackMapper.getByState("未处理");
        return list.indexOf(s);
    }
    @Override
    public Date getTime(){
        //修改jvm时间
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        Date date= new Date();
        return date;
    }
    @Override
    public void setTime(FeedBackMsg fd){
        fd.setDealTime(getTime());
        feedBackMapper.updateDealTime(fd);
    }
    @Override
    public void updateState(FeedBackMsg fd){
        feedBackMapper.updateState(fd);
    }
    @Override
    public void updateMsg(FeedBackMsg fd){
        feedBackMapper.updateMsg(fd);
    }


}
