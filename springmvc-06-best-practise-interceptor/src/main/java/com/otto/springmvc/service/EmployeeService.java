package com.otto.springmvc.service;

import com.otto.springmvc.bean.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findEmployeeById(Integer id);

    void addEmployee(Employee employee);

    void changeEmployee(Employee employee);

    void removeEmployeeById(Integer id);

    List<Employee> findEmployees();
}
