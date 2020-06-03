package com.qingyou.threePart.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Msg;
import com.qingyou.threePart.model.Student;
import com.qingyou.threePart.repository.MsgMapper;
import com.qingyou.threePart.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public PageInfo getHistoryPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Msg> list= msgMapper.getByHistory("y");//是历史记录

        return new PageInfo<>(list);
    }
    @Override
    public Msg getMsg(String userId){
        Msg m =msgMapper.getOne(userId);
        return m;
    }
    @Override
    public void updateHistory(Msg m){
        msgMapper.updateHistory(m);
    }
    @Override
    public void insertMsg(Msg m){
        msgMapper.insert(m);
    }
}
