package com.qingyou.threePart.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class FeedBackMsg {

    private Integer id;

    private String userid; //y用户唯一识别

    private String name;

    private String state;

    private String photo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date subTime; //提交时间

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dealTime; //处理时间

    private String msg;

    public String getUserid() {
        return userid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public Date getSubTime() {
        return subTime;
    }

    public Integer getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
