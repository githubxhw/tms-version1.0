package com.itlover.tms.mapper.impl;

import com.itlover.tms.mapper.ITeacherMapper;
import com.itlover.tms.pojo.Teacher;
import com.itlover.tms.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class TeacherMapperImpl implements ITeacherMapper {

    @Override
    public List<Teacher> findAll() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.query("select * from t_teacher", new BeanListHandler<Teacher>(Teacher.class));
    }
}
