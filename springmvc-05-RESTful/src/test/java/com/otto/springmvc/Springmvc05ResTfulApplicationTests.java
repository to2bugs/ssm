package com.otto.springmvc;
import java.math.BigDecimal;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.dao.EmployeeDao;
import com.otto.springmvc.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Springmvc05ResTfulApplicationTests {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

    @Test
    void testFindEmployeeById() {
        Integer id = 1;
        // Employee employee = employeeDao.getEmployeeById(1);
        Employee employee = employeeService.findEmployeeById(1);
        log.info("根据员工编号: {}，获取员工信息: {}", id, employee);
    }

    @Test
    void testInsertEmployee() {
        Employee employee = new Employee();
        employee.setName("李四");
        employee.setAge(10);
        employee.setEmail("aaa@gmail.com");
        employee.setGender("女");
        employee.setAddress("上赶子村");
        employee.setSalary(new BigDecimal("0.1"));

        // employeeDao.insertEmployee(employee);
        employeeService.addEmployee(employee);
    }

    /**
     * 注意：传入Employee全部的值哦，不修改的值要保持原值，重要‼️
     *      如果不传，代表修改为null‼️
     */
    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(6);
        // employee.setName("李四"); // 不修改的要保持原值哦，重要‼️
        // employee.setAge(34);
        // employee.setEmail("aaa@gmail.com");  // 不修改的要保持原值哦，重要‼️
        // employee.setGender("男");
        // employee.setAddress("下水塘河村");
        employee.setSalary(new BigDecimal("13028.34"));

        // employeeDao.updateEmployee(employee);
        employeeService.changeEmployee(employee);
    }

    @Test
    void testDeleteEmployeeById() {
        // employeeDao.deleteEmployeeById(5);
        employeeService.removeEmployeeById(6);
    }

    @Test
    void testGetEmployees() {

    }
}
