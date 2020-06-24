package com.itlover.tms.pojo;

import java.io.Serializable;

//对应表t_student
public class Student implements Serializable {

    private int studentId;//学生ID
    private String studentCode;//学号 学号不能重复，5位字符
    private String studentName;//姓名
    private int sex;//性别:0/1 男/女
    private String sexStr;
    private int grade;//年级 入学年份，4位整数
    private int major;//专业: 1软件工程 2空间信息 3大数据
    private String majorStr;
    private String detail;//备注

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentCode='" + studentCode + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex=" + sex +
                ", sexStr='" + sexStr + '\'' +
                ", grade=" + grade +
                ", major=" + major +
                ", majorStr='" + majorStr + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getMajorStr() {
        return majorStr;
    }

    public void setMajorStr(String majorStr) {
        this.majorStr = majorStr;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        if(sex == 0){
            this.sexStr = "男";
        }else if(sex == 1){
            this.sexStr = "女";
        }
        //...
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        if(major == 1){
            this.majorStr = "软件工程";
        }else if(major == 2){
            this.majorStr = "空间信息";
        }else if(major == 3){
            this.majorStr = "大数据";
        }
        //...
        this.major = major;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
