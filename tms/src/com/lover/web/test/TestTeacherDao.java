package com.lover.web.test;

import com.lover.web.mapper.ITeacherMapper;
import com.lover.web.mapper.impl.TeacherMapperImpl;
import com.lover.web.pojo.Teacher;

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
