package com.course.testng.paramter;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    //parameter.xml文件右键运行
    @Test
    @Parameters({"name", "age"})
    public void paramTest1(String name, int age) {
        System.out.println("name=" + name + ";" + "age=" + age);
    }

    @Test
    public void paramTest2(@Optional("张三") String name, @Optional("27") int age) {
        System.out.println("name=" + name + ";" + "age=" + age);
    }

}
