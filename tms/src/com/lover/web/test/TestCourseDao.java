package com.lover.web.test;

import com.lover.web.mapper.ICourseMapper;
import com.lover.web.mapper.impl.CourseMapperImpl;
import com.lover.web.pojo.Course;

import java.util.List;

public class TestCourseDao {

    public static void main(String[] args) {
        try {
            ICourseMapper courseMapper = new CourseMapperImpl();
            List<Course> courses = courseMapper.findAll();
            for (Course course : courses){
                System.out.println(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
