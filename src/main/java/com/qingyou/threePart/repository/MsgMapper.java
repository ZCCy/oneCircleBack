package com.qingyou.threePart.repository;

import com.qingyou.threePart.model.Msg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author whz
 */
@Mapper
@Repository
public interface MsgMapper {

    @Select("SELECT * FROM msg  WHERE msg_history = #{history}")    //表名
    @Results({
        @Result(column="id", property="id", id=true),
        @Result(column="userid", property="userid"),
        @Result(column="msg_history ", property="history"),
        @Result(column="msg_title", property="title"),
        @Result(column="push_time", property="time"),
        @Result(column="msg", property="msg"),

    })
    List<Msg> getByHistory(String history);

    @Select("SELECT * FROM msg WHERE userid = #{userid}")
    @Results({
            @Result(column="id", property="id", id=true),
            @Result(column="userid", property="userid"),
            @Result(column="msg_history ", property="history"),
            @Result(column="msg_title", property="title"),
            @Result(column="push_time", property="time"),
            @Result(column="msg", property="msg"),

    })
    Msg getOne(String userid);

    @Insert("INSERT INTO msg(userid,msg,push_time,state,msg_history,msg_title) VALUES(#{userid}, #{msg}, #{time},#{state},#{history},#{title})")
    void insert(Msg m);

    @Update("UPDATE msg SET msg_history=#{history} WHERE userid =#{userid}")
    void updateHistory(Msg m);

    //@Delete("DELETE FROM msg WHERE userid =#{userid}")
   // void delete(Long id);

}