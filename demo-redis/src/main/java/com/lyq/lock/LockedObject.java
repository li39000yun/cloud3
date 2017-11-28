package com.lyq.lock;

import java.lang.annotation.*;

/**
 * Created by 云强 on 2017/11/14.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedObject {
    //不需要值
}
