package com.itlover.tms.pojo;

import java.io.Serializable;

//对应表t_user
public class User implements Serializable {

    private String userId;//用户ID
    private String loginName;//用户名
    private String password;//密码

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
