package com.qingyou.commodityPools.dao;

import com.qingyou.commodityPools.enityt.CommodityPools;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityPoolsDao {
    List<CommodityPools> getList();
    List<CommodityPools> getStarList();
    List<CommodityPools> getDownList();
    CommodityPools srchById(long id);
}
