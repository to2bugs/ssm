package com.otto.mybatis;

import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.mapper.EmpMapper;
import com.otto.mybatis.mapper.EmpMultiParamMapper;
import com.otto.mybatis.mapper.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
public class ParamTest {

    @Autowired
    private EmpParamMapper empParamMapper;
    @Autowired
    private EmpMultiParamMapper empMultiParamMapper;

    @Test
    public void testParam1() {
        Emp employ = empParamMapper.getEmploy(1);
        System.out.println(employ);
    }

    @Test
    public void testParam2() {
        Emp employ = empParamMapper.getEmploy02(Arrays.asList(1,2,3));
        System.out.println(employ);
    }

    @Test
    public void testParam3() {
        Emp emp = new Emp();
        emp.setEmpName("totbage");
        emp.setAge(50);
        emp.setEmpSalary(12345.0D);

        empParamMapper.addEmploy(emp);
    }

    @Test
    public void testParam4() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("empName", "小丽");
        map.put("age", 21);
        map.put("empSalary", 92345.0D);
        empParamMapper.addEmploy02(map);
    }

    @Test
    public void testParam5() {
        Emp tom = empMultiParamMapper.getEmployByIdAndName(1, "tom");
        System.out.println(tom);
    }

    @Test
    public void testParam6() {
        // map
        HashMap<String, Object> map = new HashMap<>();
        map.put("empName", "小丽");
        map.put("age", 21);
        map.put("empSalary", 92345.0D);
        // emp
        Emp emp = new Emp();
        emp.setEmpName("totbage");
        emp.setAge(50);
        emp.setEmpSalary(12345.0D);

        empMultiParamMapper.getEmployFlux(1, map, Arrays.asList(10, 23, 45, 56), emp);
    }
}
