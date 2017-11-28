package com.lyq.lock;

/**
 * redis锁
 * Created by 云强 on 2017/11/14.
 */
public interface DistributionLock {

    //加锁成功 返回加锁时间
    public Long lock(String lockKey, String threadname);

    //解锁 需要更加加锁时间判断是否有权限
    public void unlock(String lockKey, long lockvalue, String threadname);
}
