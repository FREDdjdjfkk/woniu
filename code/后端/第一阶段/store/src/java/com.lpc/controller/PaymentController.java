package com.lpc.controller;

import com.lpc.Service.PaymentService;
import com.lpc.pojo.Payment;
import com.lpc.pojo.StatusPayment;

public class PaymentController {
    PaymentService paymentService=new PaymentService();

    public int addPayment(Integer oid,String method,double total,String tid){
        Payment p=new Payment();
        p.setOrderId(oid);
        p.setPayment_method(method);
        p.setAmount(total);
        p.setTransaction_id(tid);
       return paymentService.addPayment(p);
    }
    public void changeStatus(String s,int pid){
        StatusPayment newStatus;
        try {
            newStatus = StatusPayment.valueOf(s.toLowerCase()); // 根据字符串获取枚举
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 错误：无效的支付状态 -> " + s);
            return;
        }

        Payment p=new Payment();
        p.setStatus(newStatus);
        p.setPaymentId(pid);

        paymentService.changePayment(p);
    }

    public Integer findOid(Integer pid){
        return paymentService.fiadOid(pid);
    }
}
