package com.otto.springmvc.dao.impl;

import com.otto.springmvc.bean.Employee;
import com.otto.springmvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql = "select * from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "insert into employee (name, age, email, gender, address, salary, birth) values (?, ?, ?, ?, ?, ?, ?)";
        int cnt = jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(), employee.getAddress(), employee.getSalary(), employee.getBirth());
        System.out.println("新增成功，影响行数: " + cnt);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
        int cnt = jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(), employee.getAddress(), employee.getSalary(), employee.getId());
        System.out.println("更新成功，影响行数: " + cnt);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        String sql = "delete from employee where id = ?";
        int cnt = jdbcTemplate.update(sql, id);
        System.out.println("删除成功，影响行数: " + cnt);
    }

    @Override
    public List<Employee> getEmployees() {
        String sql = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }
}
