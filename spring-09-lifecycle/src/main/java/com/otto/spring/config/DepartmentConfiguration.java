package com.otto.spring.config;

import com.otto.spring.bean.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfiguration {

    @Bean
    public Department department() {
        Department department = new Department();
        department.setDeptId("01");
        department.setDeptName("生产部");

        return department;
    }
}
