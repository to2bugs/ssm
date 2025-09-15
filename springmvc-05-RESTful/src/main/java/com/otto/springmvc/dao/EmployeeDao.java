package com.otto.springmvc.dao;

import com.otto.springmvc.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 新增某个员工
     * @param employee
     */
    void insertEmployee(Employee employee);


    /**
     * 修改某个员工
     * @param employee
     */
    void updateEmployee(Employee employee);


    /**
     * 根据id删除某个员工
     * @param id
     */
    void deleteEmployeeById(Integer id);


    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getEmployees();
}
