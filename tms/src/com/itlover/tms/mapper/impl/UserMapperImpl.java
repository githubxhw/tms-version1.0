package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.IUserMapper;
import com.itlover.tms.pojo.User;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserMapperImpl implements IUserMapper {

    @Override
    public User findByName(String loginName) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from `t_user` where loginName=?";
        return queryRunner.query(sql,new BeanHandler<>(User.class),loginName);
    }
}
