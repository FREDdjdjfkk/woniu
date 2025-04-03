package com.lpc.util;

import java.util.Date;
import java.util.UUID;

public class IDUtils {

    /**
     * 随机uuid
     */
    public static String randomId(){
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

    /**
     * 根据时间毫秒数生成id
     */
    public static Long randomTimeId(){
        return new Date().getTime();
    }
}
