package com.itlover.tms.mapper;

import com.itlover.tms.pojo.Score;

import java.util.List;

/**
 * Score的mapper接口
 */
public interface IScoreMapper {

    //查询所有的Score信息
    List<Score> findAll() throws Exception;

    //分页查询Score信息
    List<Score> findAllByPage(int pageNum, int pageSize) throws Exception;

    //查询Score的数量
    Long findCount() throws Exception;

    //根据StuId查询信息
    Score findById(int parseInt,int parseInt1) throws Exception;

    //根据StuId更新消息
    Integer updateById(Score score) throws Exception;

    //根据id删除信息
    Integer deleteByStuId(int parseInt,int parseInt2) throws Exception;

    Integer save(Score score) throws Exception;
}
