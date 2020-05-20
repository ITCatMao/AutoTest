package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1() {
        System.out.println("服务端servertest1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("服务端servertest2");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端clienttest3");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("客户端clienttest4");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("server运行之前运行的方法BeforeGroups");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("server运行之后运行的方法AfterGroups");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("client运行之前运行的方法BeforeGroups");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient() {
        System.out.println("client运行之后运行的方法AfterGroups");
    }
}
