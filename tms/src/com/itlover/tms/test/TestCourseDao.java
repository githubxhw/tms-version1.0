package com.itlover.tms.test;

import com.itlover.tms.mapper.ICourseMapper;
import com.itlover.tms.mapper.impl.CourseMapperImpl;
import com.itlover.tms.pojo.Course;

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
