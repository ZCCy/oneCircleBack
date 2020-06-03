package com.qingyou.threePart.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Msg {

    private int id;

    private String userid;

    private String title;

    private String state;

    private String msg;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date time;

    private String history;


    public int getId() {
        return id;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getUserId() {
        return userid;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Date getTime() {
        return time;
    }

    public String getMsg() {
        return msg;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
