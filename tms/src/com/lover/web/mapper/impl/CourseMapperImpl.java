package com.lover.web.mapper.impl;

import com.lover.web.mapper.ICourseMapper;
import com.lover.web.pojo.Course;
import com.lover.web.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class CourseMapperImpl implements ICourseMapper {

    @Override
    public List<Course> findAll() throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_course";
        return queryRunner.query(sql, new BeanListHandler<Course>(Course.class));
    }

    @Override
    public List<Course> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_course limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<Course>(Course.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_course";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public Course findById(int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_course where courseId=?";
        return queryRunner.query(sql, new BeanHandler<Course>(Course.class),courseId);
    }

    @Override
    public Integer updateById(Course course) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_course set courseName=?,type=?,credit=?,grade=?,major=?,detail=? where courseId=?";
        return queryRunner.update(sql, course.getCourseName(),course.getType(),course.getCredit(),course.getGrade(),course.getMajor(),course.getDetail(),course.getCourseId());
    }

    @Override
    public Integer deleteByCourseId(int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_course where courseId=?";
        return queryRunner.update(sql, courseId);
    }

    @Override
    public Integer saveNotHasId(Course course) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_course (courseName,type,credit,grade,major,detail) values (?,?,?,?,?,?)";
        return queryRunner.update(sql, course.getCourseName(),course.getType(),course.getCredit(),course.getGrade(),course.getMajor(),course.getDetail());
    }


}
