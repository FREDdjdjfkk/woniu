package com.lpc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    private Integer id;
    private String name;
    private String companyId;
    private Date buildDate;
    private Integer number;
}