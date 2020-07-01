package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.ITeacherMapper;
import com.itlover.tms.pojo.Teacher;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class TeacherMapperImpl implements ITeacherMapper {

    @Override
    public List<Teacher> findAll() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.query("select * from t_teacher", new BeanListHandler<Teacher>(Teacher.class));
    }

    @Override
    public List<Teacher> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_teacher limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_teacher";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public Teacher findById(int teacherId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_teacher where teacherId=?";
        return queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),teacherId);
    }
    @Override
    public Integer updateById(Teacher teacher) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_teacher set " +
                "teacherName=?,sex=?,birthday=?,education=?," +
                "title=?,department=?,detail=? where teacherId=?";
        return queryRunner.update(sql,teacher.getTeacherName(),teacher.getSex(),
                teacher.getBirthday(),teacher.getEducation(),teacher.getTitle()
                ,teacher.getDepartment(),teacher.getDetail(),teacher.getTeacherId());
    }

    @Override
    public Integer deleteByTId(int teacherId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_teacher where teacherId=?";
        return queryRunner.update(sql, teacherId);
    }

    @Override
    public Integer save(Teacher teacher) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_teacher" +
                "(teacherName,sex,birthday,education," +
                "title,department,detail)" +
                " values (?,?,?,?,?,?,?)";
        return queryRunner.update(sql,teacher.getTeacherName()
                ,teacher.getSex(),teacher.getBirthday(),teacher.getEducation(),teacher.getTitle()
                ,teacher.getDepartment(),teacher.getDetail());
    }
}
