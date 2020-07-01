package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.IScoreMapper;
import com.itlover.tms.pojo.Score;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ScoreMapperImpl implements IScoreMapper {

    @Override
    public List<Score> findAll() throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_score";
        return queryRunner.query(sql, new BeanListHandler<Score>(Score.class));
    }

    @Override
    public List<Score> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_score limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<Score>(Score.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_score";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public Score findById(int studentId,int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_score where studentId=? and courseId=?";
        return queryRunner.query(sql, new BeanHandler<Score>(Score.class),studentId,courseId);
    }

    @Override
    public Integer updateById(Score score) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_score set score=? where studentId=? and courseId=?";
        return queryRunner.update(sql, score.getScore(),score.getStudentId(),score.getCourseId());
    }
    @Override
    public Integer deleteByStuId(int studentId,int courseId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_score where studentId=? and courseId=?";
        return queryRunner.update(sql, studentId,courseId);
    }

    @Override
    public Integer save(Score score) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_score (studentId,courseId,score) values (?,?,?)";
        return queryRunner.update(sql, score.getStudentId(),score.getCourseId(),score.getScore());
    }
}
