package com.tester.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface TestResultDao {
    /**
     * 插入测试结果
     */
    @Insert("INSERT INTO test_result(item,code, start_time,result,url,method,response) VALUES(#{item}, #{code}, #{start_time}, #{result},#{url},#{method},#{response})")
    void insertResult(
                      @Param("item") String item,
                      @Param("code") Integer code,
                      @Param("start_time") Date startTime,
                      @Param("result") String result,
                      @Param("url") String url,
                      @Param("method") String method,
                      @Param("response") String response);


}
