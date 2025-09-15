package com.otto.springmvc.service.impl;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.dao.EmployeeDao;
import com.otto.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    /**
     * 更新操作的防null处理‼️
     *      因为Service层是被Controller层调用的，而Controller层传来的某些属性可能为null，所以要先处理一下
     *      否则Dao层更新后该字段的值就是null
     *
     *      怎么处理呢‼️⚠️
     *      1， 先根据id查询到该员工的原来🌛的值
     *      2， 再将参数employee中的值覆盖原来🌛的值，生成新🌞的值，‼️而参数employee中没有得值，自然就保持原值了
     * @param employee
     */
    @Override
    public void changeEmployee(Employee employee) {
        // 获取原来的值
        Integer id = employee.getId();
        if (id == null) {
            // 如果id都没有出现在参数employee中，那么就不需要任何的操作了
            // todo: 此处应该抛出错误的‼️
            return;
        }
        Employee originEmp = employeeDao.getEmployeeById(id);

        // 用参数employee覆盖掉originEmp中的值
        if (StringUtils.hasText(employee.getName())) {
            originEmp.setName(employee.getName());
        }
        if (StringUtils.hasText(employee.getEmail())) {
            originEmp.setEmail(employee.getEmail());
        }
        if (StringUtils.hasText(employee.getGender())) {
            originEmp.setGender(employee.getGender());
        }
        if (StringUtils.hasText(employee.getAddress())) {
            originEmp.setAddress(employee.getAddress());
        }
        if (employee.getAge() != null) {
            originEmp.setAge(employee.getAge());
        }
        if (employee.getSalary() != null) {
            originEmp.setSalary(employee.getSalary());
        }

        employeeDao.updateEmployee(originEmp);
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeDao.getEmployees();
    }
}
