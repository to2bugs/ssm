package com.otto.mybatis;

import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.mapper.EmpReturnValueMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
public class ReturnValueTest {
    @Autowired
    private EmpReturnValueMapper empReturnValueMapper;

    @Test
    public void testReturnBasicType() {
        Integer count = empReturnValueMapper.countEmp();
        System.out.println("count:" + count);

        BigDecimal empSalary = empReturnValueMapper.getEmpSalaryById(1);
        System.out.println("empSalary:" + empSalary);

        Map<Integer, Emp> employees = empReturnValueMapper.getAllEmployee();
        System.out.println("employees:" + employees);

        // 此处会报错的‼️class java.util.HashMap cannot be cast to class com.otto.mybatis.bean.Emp
        // employees中的value的类型不是Emp，而是HashMap
        Emp emp = employees.get(3);
        System.out.println("emp:" + emp);
    }

    @Test
    public void testReturnMap() {
        Emp emp = empReturnValueMapper.getEmpById01(1);
        System.out.println("emp:" + emp);
    }
}
