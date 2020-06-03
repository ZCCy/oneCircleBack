package com.qingyou.threePart.service;

import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Msg;

public interface MsgService {

    public PageInfo getHistoryPage(int pageNum, int pageSize);
    public void updateHistory(Msg m);
    public Msg getMsg(String userId);
    public void insertMsg(Msg m);
}
