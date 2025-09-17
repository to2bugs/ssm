package com.otto.springmvc.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmployeeRespVo {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;

    // 修改默认的日期格式 1975-09-16T06:12:49.000+00:00 为 yyyy-MM-dd HH:mm:ss，并指定时区
    // 否则会报错的
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
