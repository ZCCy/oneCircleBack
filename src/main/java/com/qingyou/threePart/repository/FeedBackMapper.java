package com.qingyou.threePart.repository;

import com.qingyou.threePart.model.FeedBackMsg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedBackMapper {


    @Select("SELECT * FROM feedback  WHERE state = #{state}")    //表名
    @Results({
            @Result(column="id", property="id", id=true),
            @Result(column="userid", property="userid"),
            @Result(column="name ", property="name"),
            @Result(column="state", property="state"),
            @Result(column="photo", property="photo"),
            @Result(column="msg", property="msg"),
            @Result(column= "sub_time",property = "subTime"),
            @Result(column = "deal_time",property = "dealTime")

    })
    List<FeedBackMsg> getByState(String state);


    @Select("SELECT * FROM feedback WHERE userid = #{userid}")
    @Results({
            @Result(column="id", property="id", id=true),
            @Result(column="userid", property="userid"),
            @Result(column="name ", property="name"),
            @Result(column="state", property="state"),
            @Result(column="photo", property="photo"),
            @Result(column="msg", property="msg"),
            @Result(column= "sub_time",property = "subTime"),
            @Result(column = "deal_time",property = "dealTime")

    })
    FeedBackMsg getOne(String userid);


    @Update("UPDATE feedback SET deal_time=#{dealTime} WHERE userid =#{userid}")
    void updateDealTime(FeedBackMsg msg);

    @Update("UPDATE feedback SET state=#{state} WHERE userid =#{userid}")
    void updateState(FeedBackMsg feedBackMsg);

    @Update("UPDATE feedback SET msg=#{msg} WHERE userid =#{userid}")
    void updateMsg(FeedBackMsg feedBackMsg);
}
