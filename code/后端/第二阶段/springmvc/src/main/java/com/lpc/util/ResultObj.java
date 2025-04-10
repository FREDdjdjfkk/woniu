package com.lpc.util;

/**
 * 封装响应结果实体对象
 */
public class ResultObj {

    private Integer code;
    private String msg;
    public boolean success;
    private Object data;

    /**
     * 设置响应数据
     */
    public ResultObj data(Object result){
        this.data = result;
        return this;
    }
    /**
     * 设置响应码
     */
    public ResultObj code(Integer code){
        this.code = code;
        return this;
    }

    public ResultObj msg(String msg){
        this.msg = msg;
        return this;
    }

    public ResultObj success(boolean success){
        this.success = success;
        return this;
    }


    /**
     * 定义静态方法封装请求成功信息
     */
    public static ResultObj ok() {
        ResultObj result = new ResultObj();
        result.code = 200;
        result.msg = "请求成功";
        result.success = true;
        return result;
    }

    public static ResultObj ok(Object data) {
        ResultObj result = new ResultObj();
        result.code = 200;
        result.msg = "请求成功";
        result.success = true;
        result.data = data;
        return result;
    }
    /**
     * 封装请求失败的方法
     */
    public static ResultObj error() {
        ResultObj result = new ResultObj();
        result.code = 500;
        result.msg = "请求失败";
        result.success = false;
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
