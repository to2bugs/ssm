package com.otto.springmvc.vo.req;

import com.otto.springmvc.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeUpdateVo {
    @NotNull(message = "{id.notnull.message}")
    private Integer id;

    private String name;

    @Max(value = 150, message = "{age.max.message}")
    @Min(value = 18, message = "{age.min.message}")
    private Integer age;

    @Email(message = "{email.format.message}")
    private String email;

    // 只能是男or女
    // @Pattern(regexp = "^[男女]$", message = "性别只能是男或者是女，别无选择") // 使用正则校验
    // @Gender(message = "性别只能是男或者是女")
    @Gender(message = "{gender.error.message}", required = true) // "{}" 占位符，参见classpath:messages.properties
    private String gender;

    private String address;
    private BigDecimal salary;
}
