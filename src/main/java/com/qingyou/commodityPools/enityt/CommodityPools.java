package com.qingyou.commodityPools.enityt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class CommodityPools {

    private long id;

    private String title;

    private String status;

    private Timestamp create_time;

    private Timestamp update_time;

    @JsonIgnore
    private Boolean star;//1:标记   0:没有标记

    private long update_by;

    @JsonIgnore
    private long del_flag;

    @Override
    public String toString() {
        return "CommodityPools{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_by=" + update_by +
                ", del_flag=" + del_flag +
                '}';
    }

    public Boolean getStar() {
        return star;
    }

    public CommodityPools setStar(Boolean star) {
        this.star = star;
        return this;
    }

    public long getDel_flag() {
        return del_flag;
    }

    public CommodityPools setDel_flag(long del_flag) {
        this.del_flag = del_flag;
        return this;
    }

    public long getId() {
        return id;
    }

    public CommodityPools setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CommodityPools setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CommodityPools setStatus(String  status) {
        this.status = status;
        return this;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public CommodityPools setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
        return this;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public CommodityPools setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
        return this;
    }

    public long getUpdate_by() {
        return update_by;
    }

    public CommodityPools setUpdate_by(long update_by) {
        this.update_by = update_by;
        return this;
    }
}
