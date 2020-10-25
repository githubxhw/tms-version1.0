package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.ITcMapper;
import com.itlover.tms.pojo.Tc;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class TcMapperImpl implements ITcMapper {

    @Override
    public List<Tc> findAll() throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select t_tc.teacherId, t_teacher.teacherName, t_tc.courseId, t_course.courseName from " +
                "t_tc,t_teacher,t_course where t_tc.teacherId=t_teacher.teacherId and t_tc.courseId=t_course.courseId " +
                "order by t_tc.teacherId";
        return queryRunner.query(sql, new BeanListHandler<Tc>(Tc.class));
    }

    @Override
    public List<Tc> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select t_tc.teacherId, t_teacher.teacherName, t_tc.courseId, t_course.courseName from " +
                "t_tc,t_teacher,t_course where t_tc.teacherId=t_teacher.teacherId and t_tc.courseId=t_course.courseId " +
                "order by t_tc.teacherId limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<Tc>(Tc.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_tc";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public Tc findById(int teacherId,int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select t_tc.teacherId, t_teacher.teacherName, t_tc.courseId, t_course.courseName from t_tc,t_teacher,t_course where teacherId=? and courseId=?";
        return queryRunner.query(sql, new BeanHandler<Tc>(Tc.class),teacherId,courseId);
    }
    @Override
    public Integer updateById(Tc tc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_tc set " +
                "courseId=? where teacherId=?";
        return queryRunner.update(sql,tc.getCourseId(), tc.getTeacherId());
    }

    @Override
    public Integer deleteByTeacherId(int teacherId,int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_tc where teacherId=? and courseId=?";
        return queryRunner.update(sql, teacherId,courseId);
    }

    @Override
    public Integer save(Tc tc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_tc (teacherId,courseId) values (?,?)";
        return queryRunner.update(sql, tc.getTeacherId(),tc.getCourseId());
    }
}
