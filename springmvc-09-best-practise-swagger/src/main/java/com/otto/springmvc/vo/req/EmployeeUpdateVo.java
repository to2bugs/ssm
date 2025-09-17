package com.otto.springmvc.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "员工修改提交的数据")
@Data
public class EmployeeUpdateVo {
    @Schema(description = "员工id")
    @NotNull(message = "{employee-id-notnull-message}")
    private Integer id;

    @Schema(description = "员工姓名")
    private String name;

    @Schema(description = "员工年龄")
    private Integer age;

    @Schema(description = "员工邮箱")
    private String email;

    @Schema(description = "员工性别")
    private String gender;

    @Schema(description = "员工住址")
    private String address;

    @Schema(description = "员工薪资")
    private BigDecimal salary;
}
