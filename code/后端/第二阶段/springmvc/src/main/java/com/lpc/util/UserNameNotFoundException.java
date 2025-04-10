package com.lpc.util;

/**
 * 自定义异常，由controller复制抛出异常逻辑
 */
public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(){
        super();
    }

    public UserNameNotFoundException(String message){
        super(message);
    }
}
