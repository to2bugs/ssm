package com.otto.spring.bean;

import com.otto.spring.annotation.Uuid;
import lombok.Data;

@Data
public class Department {
    @Uuid
    private String deptId;
    private String deptName;
}
