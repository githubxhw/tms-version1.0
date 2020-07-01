package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.IStudentMapper;
import com.itlover.tms.pojo.Sc;
import com.itlover.tms.pojo.Student;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class StudentMapperImpl implements IStudentMapper {
    @Override
    public List<Student> findAll() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_student";
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
    }

    @Override
    public List<Student> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_student limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_student";
        return (long)queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public Student findByStudentId(int studentId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_student where studentId=?";
        return queryRunner.query(sql, new BeanHandler<Student>(Student.class),studentId);
    }

    @Override
    public int saveHasNotId(Student student) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_student (`studentCode`,`studentName`,`sex`,`grade`,`major`,`detail`) values (?,?,?,?,?,?)";
        return queryRunner.update(sql,student.getStudentCode(),student.getStudentName(),student.getSex(),student.getGrade(),student.getMajor(),student.getDetail());
    }

    @Override
    public int updateById(Student student) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_student set studentCode=?,studentName=?,sex=?,grade=?,major=?,detail=? where studentId=?";
        return queryRunner.update(sql,student.getStudentCode(),student.getStudentName(),student.getSex(),student.getGrade(),student.getMajor(),student.getDetail(),student.getStudentId());
    }

    @Override
    public int deleteById(int studentId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_student where studentId=?";
        return queryRunner.update(sql,studentId);
    }

    @Override
    public Object findStudentIdByStudentCode(String studentCode) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select `studentId` from t_student where studentCode=?";
        return queryRunner.query(sql, new ScalarHandler(),studentCode);
    }

    @Override
    public List<Sc> findScByStudentId(int studentId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_sc where studentId=?";
        return queryRunner.query(sql, new BeanListHandler<Sc>(Sc.class),studentId);
    }

    @Override
    public Sc findScByStudentIdAndCourseId(Sc sc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_sc where studentId=? and courseId=?";
        return queryRunner.query(sql, new BeanHandler<>(Sc.class),sc.getStudentId(),sc.getCourseId());
    }

    @Override
    public void saveSc(Sc sc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_sc (`studentId`,`courseId`) value (?,?)";
        queryRunner.update(sql,sc.getStudentId(),sc.getCourseId());
        return;
    }

    @Override
    public Student findStudentByStudentCode(String studentCode) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_student where studentCode=?";
        return queryRunner.query(sql,new BeanHandler<Student>(Student.class),studentCode);
    }

    @Override
    public int deleteScByStudentIdAndCourseId(int studentId, int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_sc where studentId=? and courseId=?";
        return queryRunner.update(sql,studentId,courseId);
    }
}
