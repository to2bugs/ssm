package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.common.R;
import com.otto.springmvc.service.EmployeeService;
import com.otto.springmvc.vo.req.EmployeeAddVo;
import com.otto.springmvc.vo.req.EmployeeUpdateVo;
import com.otto.springmvc.vo.resp.EmployeeRespVo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
     * @Valid 开启数据的校验，其位置在 @RequestBody 的左边or右边都是可以的
     * @Valid 修饰的参数后，紧跟一个 BindingResult 参数，用来封装校验结果的
     *
     * 但是，但是，但是，这样写不好，因为校验失败，是会抛出 MethodArgumentNotValidException 异常的
     * 而 MethodArgumentNotValidException 异常，则可以在全局异常处理中捕获到
     */
    // @PostMapping("/employee")
    // public R add(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
    //     // 校验employee的字段失败
    //     if (bindingResult.hasErrors()) {
    //         // 定义data
    //         Map<String, String> errorMap = new HashMap<>();
    //         // 获取到所有的错误，并遍历
    //         List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    //         for (FieldError fieldError : fieldErrors) {
    //             // 获取到校验失败的字段
    //             String field = fieldError.getField();
    //             // 获取到校验失败的原因
    //             String errorMessage = fieldError.getDefaultMessage();
    //             errorMap.put(field, errorMessage);
    //         }
    //         // 返回
    //         return R.error(500, "校验错误", errorMap);
    //     }
    //
    //     employeeService.addEmployee(employee);
    //     return R.ok();
    // }
    // 以上的写法不好，应该让全局异常来处理校验的失败
    // 因为校验失败，是会抛出 MethodArgumentNotValidException 异常的
    @PostMapping("/employee")
    public R add(@RequestBody @Valid EmployeeAddVo employee) {
        // 将vo转换为do
        Employee emp = new Employee();
        BeanUtils.copyProperties(employee, emp); // copy employee to emp
        employeeService.addEmployee(emp);
        return R.ok();
    }

    /**
     * 要求：
     *      前端发送请求需要将员工的json数据放入请求体中发送给服务端
     *      必须携带用户的id，即employpee.id不能为null
     */
    @PutMapping("/employee")
    public R update(@RequestBody @Valid EmployeeUpdateVo employee) {
        // 将vo转换为do
        Employee emp = new Employee();
        BeanUtils.copyProperties(employee, emp);
        employeeService.changeEmployee(emp);
        return R.ok();
    }


    /**
     * 查询所有
     */
    @GetMapping("/employees")
    public R<List<EmployeeRespVo>> findAll() {
        List<Employee> employees = employeeService.findEmployees();
        List<EmployeeRespVo> employeeRespVos = new ArrayList<>();
        // 经do转换为vo
        employees.forEach(employee -> {
            EmployeeRespVo employeeRespVo = new EmployeeRespVo();
            BeanUtils.copyProperties(employee, employeeRespVo);
            employeeRespVos.add(employeeRespVo);
        });
        return R.ok(employeeRespVos);
    }
}
