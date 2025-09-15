package com.otto.springmvc.vo.req;

import com.otto.springmvc.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * vo只与前端页面交互的对象
 */
@Data
public class EmployeeAddVo {
    @NotBlank(message = "{name.notblank.message}")
    private String name;

    @NotNull(message = "{age.notnull.message}")
    @Max(value = 150, message = "{age.max.message}")
    @Min(value = 18, message = "{age.min.message}")
    private Integer age;

    @Email(message = "{email.format.message}")
    private String email;

    // 只能是男or女
    // @Pattern(regexp = "^[男女]$", message = "性别只能是男或者是女，别无选择") // 使用正则校验
    // @Gender(message = "性别只能是男或者是女")
    @Gender(message = "{gender.error.message}") // "{}" 占位符，参见classpath:messages.properties
    private String gender;

    private String address;
    private BigDecimal salary;
}
