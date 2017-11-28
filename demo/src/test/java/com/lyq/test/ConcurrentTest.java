package com.lyq.test;

/**
 * 并发测试
 * Created by 云强 on 2017/11/27.
 */
public class ConcurrentTest {


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        AccTotalConcurrent accTotalConcurrent = new AccTotalConcurrent(10);
        accTotalConcurrent.start();
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }

}
