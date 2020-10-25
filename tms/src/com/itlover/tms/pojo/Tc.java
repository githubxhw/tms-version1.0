package com.itlover.tms.pojo;

import java.io.Serializable;

//对应表t_tc
public class Tc implements Serializable {

    private int teacherId;//教师ID
    private int courseId;//课程ID
    private String teacherName;
    private String courseName;

    @Override
    public String toString() {
        return "Tc{" +
                "teacherId=" + teacherId +
                ", teacherName=" + teacherName +
                ", courseId=" + courseId +
                ", courseName=" + courseName +
                '}';
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
