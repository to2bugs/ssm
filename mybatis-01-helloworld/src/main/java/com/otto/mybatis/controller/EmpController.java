package com.otto.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/all")
    public PageInfo<Emp> all(
            @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        return empService.getEmpList(pageNum, pageSize);
    }
}
