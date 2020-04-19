package com.qingyou.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChangeComDao {
    void moveOff(@Param("comId") long comId,@Param("update_by") long updateId);
    void delCom(@Param("comId") long comId,@Param("update_by") long updateId);
    void statusChange(@Param("comId") long comId,@Param("update_by") long updateId);
}
