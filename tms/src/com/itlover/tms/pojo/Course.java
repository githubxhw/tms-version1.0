package com.itlover.tms.pojo;


import java.io.Serializable;

//对应表t_course
public class Course implements Serializable {

    private int courseId;//课程ID
    private String courseName;//名称
    private int type;//性质: 1公共基础必修课 2公共选修课 3学科基础课 4专业必修课 5专业选修课 6集中性实践教学环节
    private String typeStr;
    private float credit;//学分
    private int grade;//开设年级
    private int major;//开设专业: 1软件工程 2空间信息 3大数据
    private String majorStr;
    private String detail;//备注

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", type=" + type +
                ", typeStr='" + typeStr + '\'' +
                ", credit=" + credit +
                ", grade=" + grade +
                ", major=" + major +
                ", majorStr='" + majorStr + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getMajorStr() {
        return majorStr;
    }

    public void setMajorStr(String majorStr) {
        this.majorStr = majorStr;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if(type == 1){
            this.typeStr = "公共基础必修课";
        }else if(type == 2){
            this.typeStr = "公共选修课";
        }else if(type == 3){
            this.typeStr = "学科基础课";
        }else if(type == 4){
            this.typeStr = "专业必修课";
        }else if(type == 5){
            this.typeStr = "专业选修课";
        }else if(type == 6){
            this.typeStr = "集中性实践教学环节";
        }
        //...
        this.type = type;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
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
