package com.itlover.tms.test;

import com.itlover.tms.mapper.ITeacherMapper;
import com.itlover.tms.mapper.impl.TeacherMapperImpl;
import com.itlover.tms.pojo.Teacher;

import java.util.List;

public class TestTeacherDao {

    public static void main(String[] args) {
        try {
            ITeacherMapper teacherMapper = new TeacherMapperImpl();
            List<Teacher> teachers = teacherMapper.findAll();
            if(teachers!=null){
                for (Teacher teacher:teachers){
                    System.out.println(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
