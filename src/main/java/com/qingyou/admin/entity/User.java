package com.qingyou.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class User {

    @JsonIgnore
    public long id;

    public String username;

    @JsonIgnore
    public String password ;

    public long root;

    @JsonIgnore
    public long update_by;

    @JsonIgnore
    public Timestamp create_time;

    @JsonIgnore
    public Timestamp update_time;

    @JsonIgnore
    public long del_flag;

    @JsonIgnore
    public String msg;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", root=" + root +
                ", update_by=" + update_by +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", del_flag=" + del_flag +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public User setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getRoot() {
        return root;
    }

    public User setRoot(long root) {
        this.root = root;
        return this;
    }

    public long getUpdate_by() {
        return update_by;
    }

    public User setUpdate_by(long update_by) {
        this.update_by = update_by;
        return this;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public User setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
        return this;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public User setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
        return this;
    }

    public long getDel_flag() {
        return del_flag;
    }

    public User setDel_flag(long del_flag) {
        this.del_flag = del_flag;
        return this;
    }
}
