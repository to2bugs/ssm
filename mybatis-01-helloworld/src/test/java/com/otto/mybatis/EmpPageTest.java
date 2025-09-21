package com.otto.mybatis;

import com.github.pagehelper.PageInfo;
import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmpPageTest {

    @Autowired
    private EmpService empService;

    @Test
    public void testPage() {
        PageInfo<Emp> page = empService.getEmpList(1, 5);
        System.out.println(page);
    }
}
