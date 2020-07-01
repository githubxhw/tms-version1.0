package com.itlover.tms.pojo;

import com.itlover.tms.utils.DateConverterUtil;

import java.io.Serializable;
import java.util.Date;

//对应表t_teacher
public class Teacher implements Serializable {

    private int teacherId;//教师ID
    private String teacherName;//教师姓名
    private int sex;//性别: 0/1 男/女
    private String sexStr;
    private Date birthday;//出生日期
    private String birthdayStr;
    private String education;//学历
    private String title;//职称
    private String department;//所属部门
    private String detail;//备注

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", sex=" + sex +
                ", sexStr='" + sexStr + '\'' +
                ", birthday=" + birthday +
                ", birthdayStr='" + birthdayStr + '\'' +
                ", education='" + education + '\'' +
                ", title='" + title + '\'' +
                ", department='" + department + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        if(birthday!=null){
            this.birthdayStr = DateConverterUtil.DateToString(birthday, "yyyy-MM-dd");
        }
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
