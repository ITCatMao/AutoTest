package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    @Override
    public String toString() {
        return "AddUserCase{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", permission='" + permission + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;

}
