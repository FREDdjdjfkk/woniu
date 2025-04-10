package com.lpc.controller;

import com.lpc.bean.DateTest;
import com.lpc.util.ResultObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("date")
public class DateController {
    @RequestMapping("test")
    public ResultObj changeDate(DateTest dateTest){

        return ResultObj.ok(dateTest);
    }
}
