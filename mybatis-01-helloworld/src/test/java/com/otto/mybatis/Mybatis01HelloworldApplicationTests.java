package com.otto.mybatis;

import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis01HelloworldApplicationTests {

    // ioc容器会为每一个Mapper接口创建代理对象，之后@Autowired自动注入的就是这个代理对象
    @Autowired
    EmpMapper empMapper;

    @Test
    void testGetEmpById() {
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);
    }

    @Test
    void testAddEmp() {
        Emp emp = new Emp();
        emp.setEmpName("otto");
        emp.setAge(50);
        emp.setEmpSalary(7021.34D);

        empMapper.addEmp(emp);
        System.out.println("自增 id: " + emp.getId());
    }

    @Test
    void testUpdateEmp() {
        Emp emp = new Emp();
        emp.setId(4);
        // emp.setEmpName("");
        // emp.setAge(0);
        emp.setEmpSalary(0.0D);

        empMapper.updateEmp(emp);
    }

    @Test
    void testDeleteEmpById() {
        empMapper.deleteEmpById(4);
    }

    @Test
    void  testGetAllEmp() {
        List<Emp> emps = empMapper.getAllEmp();
        emps.forEach(System.out::println);
    }

    /**
     * 表名是通过${}拼接在sql语句中的
     */
    @Test
    void testGetEmpById2() {
        Emp emp = empMapper.getEmpById2(1, "t_emp");
        System.out.println(emp);
    }
}
