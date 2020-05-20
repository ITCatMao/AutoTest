package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String sex;
    private int age;

}

/**
 * create table user(
 * -> id int,
 * -> name varchar(20),
 * -> sex varchar(10),
 * -> age int);
 * mysql> insert into user values(1,'xiaohong','nv',28);
 * mysql> insert into user values(2,'xiaolv','nan',25);
 * mysql> insert into user values(3,'xiaozhao','nan',26);
 */
