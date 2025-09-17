package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.common.R;
import com.otto.springmvc.service.EmployeeService;
import com.otto.springmvc.vo.req.EmployeeUpdateVo;
import com.otto.springmvc.vo.req.EmpolyeeAddVo;
import com.otto.springmvc.vo.resp.EmployeeRespVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "员工管理") // 描述Controller的作用
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeRestfulController {

    @Autowired
    private EmployeeService employeeService;

    @Parameters(value = {
            // name 指定的是方法参数的名字; description 指定参数的描述信息
            // required 指定参数是否是必须的; in 表示是输入参数，且是 ParameterIn.PATH 路径参数
            @Parameter(name = "id", description = "员工的id", required = true, in = ParameterIn.PATH)
    })
    @Operation(summary = "根据id获取员工信息")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public R<EmployeeRespVo> findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findEmployeeById(id);

        EmployeeRespVo emp = new EmployeeRespVo();
        BeanUtils.copyProperties(employee, emp);
        return R.ok(emp);
    }

    @Operation(summary = "根据id删除员工信息")
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public R removeById(@PathVariable("id") Integer id) {
        employeeService.removeEmployeeById(id);
        return R.ok();
    }

    /**
     * 要求：
     *      前端发送请求需要将员工的json数据放入请求体中发送给服务端
     */
    @Operation(summary = "添加员工信息")
    @PostMapping("/employee")
    public R add(@RequestBody EmpolyeeAddVo employee) {

        Employee emp = new Employee();
        BeanUtils.copyProperties(employee, emp);

        employeeService.addEmployee(emp);
        return R.ok();
    }

    /**
     * 要求：
     *      前端发送请求需要将员工的json数据放入请求体中发送给服务端
     *      必须携带用户的id，即employpee.id不能为null
     */
    @Operation(summary = "更新员工信息")
    @PutMapping("/employee")
    public R update(@RequestBody @Valid EmployeeUpdateVo employee) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(employee, emp);
        employeeService.changeEmployee(emp);
        return R.ok();
    }


    /**
     * 查询所有
     */
    @Operation(summary = "获取所有员工信息")
    @GetMapping("/employees")
    public R<List<EmployeeRespVo>> findAll() {
        List<Employee> employees = employeeService.findEmployees();
        List<EmployeeRespVo> emps = new ArrayList();

        for (Employee employee : employees) {
            EmployeeRespVo emp = new EmployeeRespVo();
            BeanUtils.copyProperties(employee, emp);
            emps.add(emp);
        }
        return R.ok(emps);
    }
}
