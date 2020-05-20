package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProvideTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + "；" + "age=" + age);
    }


    @DataProvider(name = "data")
    public Object[] testDataProvider() {
        Object[][] objects = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 11},
                {"wangwu", 10}
        };
        return objects;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test11111方法" + name + ";" + age);

    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test22222方法" + name + ";" + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",29}
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"wangwu", 20},
                    {"zhaoliu", 20}
            };
        }
        return result;
    }

}
