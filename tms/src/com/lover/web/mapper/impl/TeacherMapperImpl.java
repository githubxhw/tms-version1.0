package com.lover.web.mapper.impl;

import com.lover.web.mapper.ITeacherMapper;
import com.lover.web.pojo.Teacher;
import com.lover.web.utils.JDBCUtil;
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
