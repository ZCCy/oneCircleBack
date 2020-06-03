package com.qingyou.threePart.repository;

import com.qingyou.threePart.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM users  WHERE state = #{state}")    //表名

    List<Student> getByState(String state);

    @Select("SELECT * FROM users WHERE userid = #{userid}")

    Student getOne(String userid);

   // @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    //void insert(Student user);

    @Update("UPDATE users SET state=#{state} WHERE userid =#{userid}")
    void updateState(Student user);

    @Update("UPDATE users SET dealTime=#{dealTime} WHERE userid =#{userid}")
    void updateDealTime(Student user);

   // @Delete("DELETE FROM users WHERE id =#{id}")
    //void delete(Long id);

}