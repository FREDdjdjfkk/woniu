package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer order_id;
    private Integer user_id;

    private Double total_amount;
    private OrderStatus status;
    private Date created_at;
    private Date updated_at;
    private List<OrderItems> orderItems;
}
enum OrderStatus {
    pending("pending"),
    processing("processing"),
    shipped("shipped"),
    delivered("delivered"),
    cancelled("cancelled");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}