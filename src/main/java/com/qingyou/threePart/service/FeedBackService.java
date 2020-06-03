package com.qingyou.threePart.service;

import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.FeedBackMsg;

import java.util.Date;

public interface FeedBackService {
    public PageInfo getList(int pageNum, int pageSize, String state);
    public FeedBackMsg getFeedBack(String userid);
    public int getPageNum(FeedBackMsg s);
    public void setTime(FeedBackMsg fd);
    public Date getTime();
    public void updateState(FeedBackMsg fd);
    public void updateMsg(FeedBackMsg fd);
}
