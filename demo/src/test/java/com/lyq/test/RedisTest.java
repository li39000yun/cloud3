package com.lyq.test;

import com.lyq.utils.DistributedLock;
import org.junit.Test;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 云强 on 2017/11/27.
 */
public class RedisTest {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
//        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
        pool = new JedisPool(config, "117.48.215.66", 6379, 3000);
    }

    DistributedLock lock = new DistributedLock(pool);

    int n = 500;

    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        String indentifier = lock.lockWithTimeout("resource", 5000, 1000);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        lock.releaseLock("resource", indentifier);
    }
//
//    @Test
//    public  void test() {
//        RedisTest service = new RedisTest();
//        for (int i = 0; i < 50; i++) {
//            ThreadA threadA = new ThreadA(service);
//            threadA.start();
//        }
//    }
}

class Test1 {
    public static void main(String[] args) {
        RedisTest service = new RedisTest();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}

class ThreadA extends Thread {
    private RedisTest service;

    public ThreadA(RedisTest service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}

