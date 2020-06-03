package com.qingyou.threePart.service;

import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Student;

import java.util.Date;

public interface StuService {

    public PageInfo getLogInfoPage(int pageNum, int pageSize, String state) ;

    public Student getByUserId(String id);

    public void updateStuState(Student stu);

    public void setTime(Student stu);

    public Date getTime();

    public void pushMsg(String userid);

    public int getPageNum(Student s);

    }
