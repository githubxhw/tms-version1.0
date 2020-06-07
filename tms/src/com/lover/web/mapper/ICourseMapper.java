package com.lover.web.mapper;

import com.lover.web.pojo.Course;

import java.util.List;

/**
 * Course的mapper接口
 */
public interface ICourseMapper {

    //查询所有的course信息
    List<Course> findAll() throws Exception;

    //分页查询course信息
    List<Course> findAllByPage(int pageNum, int pageSize) throws Exception;

    //查询course的数量
    Long findCount() throws Exception;

    //根据courseId查询信息
    Course findById(int parseInt) throws Exception;

    //根据courseId更新消息
    Integer updateById(Course course) throws Exception;

    //根据id删除信息
    Integer deleteByCourseId(int parseInt) throws Exception;

    //保存一条不包含coursId的信息
    Integer saveNotHasId(Course course) throws Exception;
}
