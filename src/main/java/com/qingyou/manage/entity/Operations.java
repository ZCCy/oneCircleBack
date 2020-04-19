package com.qingyou.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class Operations {
    private long id;

    private String operations;

    private Timestamp operaetions_time;

    private long update_By;

    private long goodId;

    @JsonIgnore
    private long del_flag;



    public long getGoodId() {
        return goodId;
    }

    public Operations setGoodId(long goodId) {
        this.goodId = goodId;
        return this;
    }

    public long getUpdate_By() {
        return update_By;
    }

    public Operations setUpdate_By(long update_By) {
        this.update_By = update_By;
        return this;
    }

    public long getId() {
        return id;
    }

    public Operations setId(long id) {
        this.id = id;
        return this;
    }

    public String getOperations() {
        return operations;
    }

    public Operations setOperations(String operations) {
        this.operations = operations;
        return this;
    }

    public Timestamp getOperaetions_time() {
        return operaetions_time;
    }

    public Operations setOperaetions_time(Timestamp operaetions_time) {
        this.operaetions_time = operaetions_time;
        return this;
    }

    public long getDel_flag() {
        return del_flag;
    }

    public Operations setDel_flag(long del_flag) {
        this.del_flag = del_flag;
        return this;
    }
}
