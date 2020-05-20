package com.course.model;

import lombok.Data;

@Data
public class GetUserInfoCase {

    @Override
    public String toString() {
        return "GetUserInfoCase{" +
                "userId=" + userId +
                ", expected='" + expected + '\'' +
                '}';
    }

    private int userId;
    private String expected;

}
