package com.lover.web.pojo;

import java.io.Serializable;

//对应表t_tc
public class Tc implements Serializable {

    private int teacherId;//教师ID
    private int courseId;//课程ID

    @Override
    public String toString() {
        return "Tc{" +
                "teacherId=" + teacherId +
                ", courseId=" + courseId +
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
}
