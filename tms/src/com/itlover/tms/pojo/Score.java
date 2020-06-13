package com.itlover.tms.pojo;

import java.io.Serializable;

//对应表t_score
public class Score implements Serializable {

    private int studentId;//学生ID
    private int courseId;//课程ID
    private float score;//分数

    @Override
    public String toString() {
        return "Score{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", score=" + score +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
