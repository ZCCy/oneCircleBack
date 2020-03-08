package com.qingyou.admin.dao;

import com.qingyou.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User foudUserByUsername(String username);
}
