package com.qingyou.manage.dao;

import com.qingyou.manage.entity.Operations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationsDao {
    void irtOperations(Operations operations);
    List<Operations> getOperationsList();
}
