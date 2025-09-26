package com.otto.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName
@Data
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField(value = "name", exist = true)
    private String name;
    @TableField(value = "age", exist = true)
    private Integer age;
    @TableField(value = "email", exist = true)
    private String email;
    @TableLogic
    private Integer deleted; // 1: 逻辑删除；0: 未逻辑删除
    @Version
    private Integer version; // 版本号字段
}
