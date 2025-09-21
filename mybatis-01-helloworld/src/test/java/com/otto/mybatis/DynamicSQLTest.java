package com.otto.mybatis;

import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.mapper.CustomerMapper;
import com.otto.mybatis.mapper.EmpDynamicSQLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DynamicSQLTest {
    @Autowired
    private EmpDynamicSQLMapper empDynamicSQLMapper;

    @Test
    public void testDynamicSQL() {
        List<Emp> emps = empDynamicSQLMapper.selectEmpByNameOrSalaryTrim("y", null);
        emps.forEach(System.out::println);
    }

    @Test
    public void testDynamicSQL2() {
        Emp emp = new Emp();
        emp.setId(7);
        emp.setEmpName("to2bage");
        // emp.setAge(10);
        // emp.setEmpSalary(23.45D);


        empDynamicSQLMapper.updateEmpTrim(emp);
    }

    @Test
    public void testDynamicSQL3() {
        List<Emp> emps = empDynamicSQLMapper.selectEmpByNameOrSalaryWhen("y", new BigDecimal("200.33"));
        emps.forEach(System.out::println);
    }

    @Test
    public void testDynamicSQL4() {
        // 查询的集合不为null
        // List<Emp> emps = empDynamicSQLMapper.getEmpsByIds(Arrays.asList(1, 3, 5, 7));
        // emps.forEach(System.out::println);

        // 查询的集合为null
        // List<Emp> emps1 = empDynamicSQLMapper.getEmpsByIds(null);
        // emps1.forEach(System.out::println);

        // 查询的集合的长度是0
        List<Emp> emps1 = empDynamicSQLMapper.getEmpsByIds(Arrays.asList());
        emps1.forEach(System.out::println);
    }

    @Test
    public void testDynamicSQL5() {
        List<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp();
            emp.setEmpName("o0" + i);
            emp.setAge(i + 50);
            emp.setEmpSalary(0.0D);

            emps.add(emp);
        }

        empDynamicSQLMapper.addEmps(emps);
    }

    @Test
    public void testDynamicSQL6() {
        List<Emp> emps = new ArrayList<>();
        for (int i = 9; i < 18; i++) {
            Emp emp = new Emp();
            emp.setId(i);
            emp.setEmpName("章_" + i);
            emp.setAge(i + 50);
            emp.setEmpSalary(10000.0D);

            emps.add(emp);
        }
        empDynamicSQLMapper.updateBatchEmps01(emps);
    }
}
