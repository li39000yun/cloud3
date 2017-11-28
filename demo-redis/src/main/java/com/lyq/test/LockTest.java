package com.lyq.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程共享输出设备
 * Created by 云强 on 2017/11/14.
 */
public class LockTest {

    //不加锁
    static class Outputer {
//        Lock lock = new ReentrantLock();
        public void output(String name) {
//            lock.lock();
//            try {
                for(int i=0; i<name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
//            }finally {
//                lock.unlock();
//            }
        }
    }
    public static void main(String[] args) {
        final Outputer output = new Outputer();
        //线程1打印zhangsan
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    output.output("zhangsan");
                }
            }
        }).start();

        //线程2打印lingsi
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    output.output("lingsi");
                }
            }
        }).start();

        //线程3打印wangwu
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    output.output("huangwu");
                }
            }
        }).start();
    }
}
