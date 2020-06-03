package com.qingyou.threePart.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Student {


    private Integer id;

    private String userid; //y用户唯一识别

    private String name;

    private Integer age;

    private String gender;

    private String schoolName;

    private String stuId;

    private String state;

    private String schoolTime;   //在校时间

    private String photo;  //图片url

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date subTime; //提交时间

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dealTime; //处理时间

    private int number;
    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuId() {
        return stuId;
    }

    public String getDate() {
        return schoolTime;
    }

    public String getGender() {
        return gender;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setDate(String date) {
        this.schoolTime = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public Date getDealTime() { return dealTime; }

    public Date getSubTime() { return subTime; }

    public void setDealTime(Date dealTime) { this.dealTime = dealTime; }

    public void setSubTime(Date subTime) { this.subTime = subTime; }

    public String getSchoolTime() {
        return schoolTime;
    }

    public String getUserId() {
        return userid;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}