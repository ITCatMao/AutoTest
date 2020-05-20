package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {

    @Override
    public String toString() {
        return "GetUserListCase{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

    private String userName;
    private String age;
    private String sex;
    private String expected;

}
