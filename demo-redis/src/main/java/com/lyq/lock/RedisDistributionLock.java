package com.lyq.lock;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁
 * Created by 云强 on 2017/11/14.
 */
public class RedisDistributionLock implements DistributionLock {

    private static final long LOCK_TIMEOUT = 60 * 1000; //加锁超时时间 单位毫秒  意味着加锁期间内执行完操作 如果未完成会有并发现象

    private static final Logger LOG = Logger.getLogger(RedisDistributionLock.class); //redis锁日志

//    @SuppressWarnings("unchecked")
//    private static RedisTemplate<Serializable, Serializable> redisTemplate = (RedisTemplate<Serializable, Serializable>) SpringContextHolder
//            .getBean("redisTemplate");

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 取到锁加锁 取不到锁一直等待直到获得锁
     */
    @Override
    public Long lock(String lockKey, String threadname) {
        LOG.info(threadname + "开始执行加锁");
        while (true) { //循环获取锁
            Long lock_timeout = System.currentTimeMillis() + LOCK_TIMEOUT + 1; //锁时间
//            if (redisTemplate.execute(new RedisCallback<Boolean>() {
//
//                @Override
//                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                    JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
//                    byte[] value = jdkSerializer.serialize(lock_timeout);
//                    return connection.setNX(lockKey.getBytes(), value);
//                }
//            })) { //如果加锁成功
//                LOG.info(threadname + "加锁成功++++++++111111111");
//                redisTemplate.expire(lockKey, LOCK_TIMEOUT, TimeUnit.MILLISECONDS); //设置超时时间，释放内存
//                return lock_timeout;
//            }else {
//                Long currt_lock_timeout_Str = (Long) redisTemplate.opsForValue().get(lockKey); // redis里的时间
//                if (currt_lock_timeout_Str != null && currt_lock_timeout_Str < System.currentTimeMillis()) { //锁已经失效
//                    // 判断是否为空，不为空的情况下，说明已经失效，如果被其他线程设置了值，则第二个条件判断是无法执行
//
//                    Long old_lock_timeout_Str = (Long) redisTemplate.opsForValue().getAndSet(lockKey, lock_timeout);
//                    // 获取上一个锁到期时间，并设置现在的锁到期时间
//                    if (old_lock_timeout_Str != null && old_lock_timeout_Str.equals(currt_lock_timeout_Str)) {
//                        // 如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
//                        LOG.info(threadname + "加锁成功+++++++2222222222");
//                        redisTemplate.expire(lockKey, LOCK_TIMEOUT, TimeUnit.MILLISECONDS); //设置超时时间，释放内存
//                        return lock_timeout;//返回加锁时间
//                    }
//                }
//            }

            try {
                LOG.info(threadname +  "等待加锁，睡眠100毫秒");
                TimeUnit.MILLISECONDS.sleep(100);//睡眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void unlock(String lockKey, long lockvalue, String threadname) {
        LOG.info(threadname + "执行解锁==========");//正常直接删除 如果异常关闭判断加锁会判断过期时间
        Long currt_lock_timeout_Str = (Long) redisTemplate.opsForValue().get(lockKey); // redis里的时间

        if (currt_lock_timeout_Str != null && currt_lock_timeout_Str == lockvalue) {//如果是加锁者 则删除锁 如果不是则等待自动过期 重新竞争加锁
            redisTemplate.delete(lockKey); //删除键
            LOG.info(threadname + "解锁成功-----------------");
        }
    }

}
