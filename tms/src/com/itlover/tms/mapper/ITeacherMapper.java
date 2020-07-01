package com.itlover.tms.mapper;

import com.itlover.tms.pojo.Teacher;

import java.util.List;

/**
 * Teacher的mapper接口
 */
public interface ITeacherMapper {

    //查询所有的tc信息
    List<Teacher> findAll() throws Exception;

    //分页查询tc信息
    List<Teacher> findAllByPage(int pageNum, int pageSize) throws Exception;

    //查询tc的数量
    Long findCount() throws Exception;

    //根据tId查询信息
    Teacher findById(int parseInt) throws Exception;

    //根据tId更新消息
    Integer updateById(Teacher teacher) throws Exception;

    //根据id删除信息
    Integer deleteByTId(int parseInt) throws Exception;

    Integer save(Teacher teacher) throws Exception;
}
