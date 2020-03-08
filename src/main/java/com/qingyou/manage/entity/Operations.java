package com.qingyou.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class Operations {
    private long id;

    private String operations;

    private Timestamp operations_time;

    @JsonIgnore
    private long del_flag;

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + id +
                ", operations='" + operations + '\'' +
                ", operations_time=" + operations_time +
                ", del_flag=" + del_flag +
                '}';
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

    public Timestamp getOperations_time() {
        return operations_time;
    }

    public Operations setOperations_time(Timestamp operations_time) {
        this.operations_time = operations_time;
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
