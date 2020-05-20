package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /***
     * 传入了某些不合法的参数，程序抛出的异常，也就是我们的预期结果就是这个异常*/

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("run failed");
    }
    //这是一个成功的异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess() {
        System.out.println("run success");
        throw new RuntimeException();
    }

}
