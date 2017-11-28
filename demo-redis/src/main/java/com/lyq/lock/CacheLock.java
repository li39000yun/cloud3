package com.lyq.lock;

import java.lang.annotation.*;

/**
 * Created by 云强 on 2017/11/14.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheLock {

    String lockedPrefix() default "";//redis 锁key的前缀

    long timeOut() default 2000;//轮询锁的时间

    int expireTime() default 1000;//key在redis里存在的时间，1000S
}
