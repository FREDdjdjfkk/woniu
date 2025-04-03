package com.lpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    private Integer user_id;
    private String username;
    private  String password_hash;
    private String email;
    private String phone_number;
    private String created_at;
    private String updated_at;
    private Integer power_id;
    private double money;
}
