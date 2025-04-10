package com.lpc.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //全局异常
    @ExceptionHandler(Exception.class)
    public ResultObj handlerException(Exception e){
        e.printStackTrace();//打印堆栈信息
        return  ResultObj.error();
    }
    //指定异常
    @ExceptionHandler(UserNameNotFoundException.class)
    public ResultObj handlerUserNameNotFoundException(UserNameNotFoundException e){
        e.printStackTrace();
        return  ResultObj.error().msg(e.getMessage());//打印controller丢过来信息
    }
}
