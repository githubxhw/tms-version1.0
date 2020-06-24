package com.itlover.tms.mapper;

import com.itlover.tms.pojo.Sc;
import com.itlover.tms.pojo.Student;

import java.util.List;

/**
 * Student的mapper接口
 */
public interface IStudentMapper {
    //查询所有的学生信息
    List<Student> findAll() throws Exception;

    //分页查询所有的学生信息
    List<Student> findAllByPage(int pageNum,int pageSize) throws Exception;

    //查询所有的数量
    long findCount() throws Exception;

    //根据student的id查询信息
    Student findByStudentId(int studentId) throws Exception;

    //添加一条记录（没有studentId）
    int saveHasNotId(Student student) throws Exception;

    //更新数据
    int updateById(Student student) throws Exception;

    //删除一条信息
    int deleteById(int parseInt) throws Exception;

    //根据学生的学号查询信息
    int findStudentIdByStudentCode(String studentCode) throws Exception;

    //根据学生的ID查询所有的Sc即student和course的选课
    List<Sc> findScByStudentId(int studentId) throws Exception;

    //根据主键查询信息
    Sc findScByStudentIdAndCourseId(Sc sc) throws Exception;

    //保存Sc
    void saveSc(Sc sc) throws Exception;

    //根据studentCode查询信息
    Student findStudentByStudentCode(String studentCode) throws Exception;

    //删除选课
    int deleteScByStudentIdAndCourseId(int studentId, int courseId) throws Exception;
}
