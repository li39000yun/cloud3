package com.lyq.utils;

import java.util.UUID;

/**
 * UUID工具类
 * Created by 云强 on 2017/11/10.
 */
public class UuidUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
