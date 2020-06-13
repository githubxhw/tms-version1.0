package com.itlover.tms.mapper;

import com.itlover.tms.pojo.Teacher;

import java.util.List;

/**
 * Teacher的mapper接口
 */
public interface ITeacherMapper {

    //查询所有的teacher信息
    List<Teacher> findAll() throws Exception;
}
