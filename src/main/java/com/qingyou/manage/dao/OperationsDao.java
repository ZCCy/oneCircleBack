package com.qingyou.manage.dao;

import com.qingyou.manage.entity.Operations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationsDao {
    void irtOperations(String operations);
    Operations getOperationsList();
}
