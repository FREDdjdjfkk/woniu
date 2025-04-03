package com.lpc.pojo;

public enum StatusPayment{
    pending("待支付"),
    completed("已完成"),
    failed("失败");

    private final String value;

    StatusPayment(String value) {
        this.value = value;
    }

}