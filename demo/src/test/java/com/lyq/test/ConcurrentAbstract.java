package com.lyq.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发工具抽象类
 * Created by 云强 on 2017/11/27.
 */
public abstract class ConcurrentAbstract {

    int concurrentNum;// 并发数
    static boolean isDebug = false;

    public ConcurrentAbstract(int num) {
        concurrentNum = num;
    }

    /**
     * 开始执行线程
     */
    public void start() {
        ExecutorService service = Executors.newCachedThreadPool(); //创建一个线程池
        final CountDownLatch cdOrder = new CountDownLatch(1);//指挥官的命令，设置为1，指挥官一下达命令，则cutDown,变为0，战士们执行任务
        final CountDownLatch cdAnswer = new CountDownLatch(concurrentNum);//因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，当三个都执行完毕，变为0，则指挥官停止等待。
        for (int i = 0; i < concurrentNum; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        if (isDebug) {
                            System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
                        }
                        cdOrder.await(); //战士们都处于等待命令状态
                        if (isDebug) {
                            System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
                        }
                        doWork();
                        if (isDebug) {
                            System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        cdAnswer.countDown(); //任务执行完毕，返回给指挥官，cdAnswer减1。
                    }
                }
            };
            service.execute(runnable);//为线程池添加任务
        }
        try {
            if (isDebug) {
                System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            }
            cdOrder.countDown(); //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
            if (isDebug) {
                System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");
            }
            cdAnswer.await(); //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
            if (isDebug) {
                System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        service.shutdown(); //任务结束，停止线程池的所有线程
    }

    /**
     * 线程需要做的事情
     * 由集成类具体实现
     */
    abstract void doWork();
}
