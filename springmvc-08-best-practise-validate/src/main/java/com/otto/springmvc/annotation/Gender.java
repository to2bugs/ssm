package com.otto.springmvc.annotation;


import com.otto.springmvc.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 自定义校验器
 * 校验器的注解必须有三个属性：message、groups、payload
 *
 * 每一个校验注解，都有一个注解@Constraint注解，其中的属性validatedBy指定校验器，校验器是来校验传来的数据的
 * 所以可以自定义校验器，参看validator.GenderValidator
 */
@Documented
@Constraint(
        validatedBy = { GenderValidator.class }
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {
    // 每一个校验注解都必须有以下三项
    String message() default "要么是男，要么是女"; // 错误消息
    Class<?>[] groups() default {}; // 分组校验，用得不多
    Class<? extends Payload>[] payload() default {}; // 负载，校验的复杂数据？？？

    // 自定义的属性
    boolean required() default true;
}
