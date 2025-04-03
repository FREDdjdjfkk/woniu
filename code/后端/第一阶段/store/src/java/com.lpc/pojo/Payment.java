package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private int paymentId;
    private int orderId;
    private String payment_method;
    private Double amount;
    private String transaction_id;
    private StatusPayment status;
    private Date created_at;
}



