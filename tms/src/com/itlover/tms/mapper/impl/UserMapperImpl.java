package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.IUserMapper;
import com.itlover.tms.pojo.User;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class UserMapperImpl implements IUserMapper {

    @Override
    public User findByName(String loginName) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from `t_user` where loginName=?";
        return queryRunner.query(sql,new BeanHandler<>(User.class),loginName);
    }

    @Override
    public List<User> findAll() throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_user";
        return queryRunner.query(sql, new BeanListHandler<User>(User.class));
    }

    @Override
    public List<User> findAllByPage(int pageNum, int pageSize) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_user limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<User>(User.class),(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long findCount() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from t_user";
        return (Long) queryRunner.query(sql, new ScalarHandler());
    }

    @Override
    public User findById(int userId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from t_user where userId=?";
        return queryRunner.query(sql, new BeanHandler<User>(User.class),userId);
    }
    @Override
    public Integer updateById(User user) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update t_user set " +
                "loginName=?,password=? where userId=?";
        return queryRunner.update(sql,user.getLoginName(), user.getPassword(),user.getUserId());
    }

    @Override
    public Integer deleteByUserId(int userId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from t_user where userId=?";
        return queryRunner.update(sql, userId);
    }

    @Override
    public Integer save(User user) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into t_user (loginName,password) values (?,?)";
        return queryRunner.update(sql, user.getLoginName(),user.getPassword());
    }

}
