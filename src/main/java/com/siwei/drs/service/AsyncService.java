package com.siwei.drs.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: AsyncService
 * @Description: TODO
 * @Author: Rui Bao
 * @Date: 2024/07/01 10:36
 **/

public class AsyncService {
    public static void main(String[] args) throws Exception {
        var clockStart = System.currentTimeMillis();
        // do something
        System.err.format("Took %,d ms\n", System.currentTimeMillis() - clockStart);
    }

    /**
     * @param countDownLatch 用于测试
     */
    @Async
    public void doSomething(CountDownLatch countDownLatch) throws InterruptedException {
        // 这里改成IO操作，比如数据库操作，网络请求等
        Thread.sleep(50);
        countDownLatch.countDown();
    }
}
