package com.qingyou.threePart.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Msg;
import com.qingyou.threePart.model.Student;
import com.qingyou.threePart.repository.UserMapper;
import com.qingyou.threePart.service.MsgService;
import com.qingyou.threePart.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MsgService msgService;
    @Autowired
    private StuService stuService;
    @Override
    public PageInfo getLogInfoPage(int pageNum, int pageSize, String state) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list= userMapper.getByState(state);
        Iterator<Student> iterator = list.iterator();

        while (iterator.hasNext()) {          //给返回前端的人员序号
            Student stu =iterator.next();
            stu.setNumber(list.indexOf(stu)+1);
        }
            return new PageInfo<>(list);

    }
    @Override
    public Student getByUserId(String userId){
        return userMapper.getOne(userId);
    }
    @Override
    public void updateStuState(Student stu){
        userMapper.updateState(stu);
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
    public void setTime(Student stu){
        stu.setDealTime(getTime());
        userMapper.updateDealTime(stu);
    }
    @Override
    public void pushMsg(String userid){
        Msg m = new Msg();
        String msg="学生认证通过";
        String title="学生认证";
        m.setUserId(userid);
        m.setTitle(title);
        m.setMsg(msg);
        m.setState("未读");
        m.setTime(stuService.getTime());
        m.setHistory("y");
        msgService.insertMsg(m);
    }
    @Override
    public int getPageNum(Student s){
        List list =userMapper.getByState("未完成");
        return list.indexOf(s);
    }

}
