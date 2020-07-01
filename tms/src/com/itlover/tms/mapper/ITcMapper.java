package com.itlover.tms.mapper;

import com.itlover.tms.pojo.Tc;

import java.util.List;

/**
 * Tc的mapper接口
 */
public interface ITcMapper {

    //查询所有的tc信息
    List<Tc> findAll() throws Exception;

    //分页查询tc信息
    List<Tc> findAllByPage(int pageNum, int pageSize) throws Exception;

    //查询tc的数量
    Long findCount() throws Exception;

    //根据tId查询信息
    Tc findById(int parseInt,int parseInt1) throws Exception;

    //根据tId更新消息
    Integer updateById(Tc tc) throws Exception;

    //根据id删除信息
    Integer deleteByTeacherId(int parseInt,int parseInt1) throws Exception;

    Integer save(Tc tc) throws Exception;
}
