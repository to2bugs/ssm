package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.common.R;
import com.otto.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeRestfulController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public R<Employee> findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findEmployeeById(id);
        return R.ok(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public R removeById(@PathVariable("id") Integer id) {
        employeeService.removeEmployeeById(id);
        return R.ok();
    }

    /**
     * 要求：
     *      前端发送请求需要将员工的json数据放入请求体中发送给服务端
     */
    @PostMapping("/employee")
    public R add(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return R.ok();
    }

    /**
     * 要求：
     *      前端发送请求需要将员工的json数据放入请求体中发送给服务端
     *      必须携带用户的id，即employpee.id不能为null
     */
    @PutMapping("/employee")
    public R update(@RequestBody Employee employee) {
        employeeService.changeEmployee(employee);
        return R.ok();
    }


    /**
     * 查询所有
     */
    @GetMapping("/employees")
    public R<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findEmployees();
        return R.ok(employees);
    }
}
