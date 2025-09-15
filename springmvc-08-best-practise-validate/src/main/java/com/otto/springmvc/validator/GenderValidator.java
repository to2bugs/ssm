package com.otto.springmvc.validator;


import com.otto.springmvc.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 自定义校验器 GenderValidator
 *      必须实现 ConstraintValidator<自定义注解名称，校验的数据类型>
 */
public class GenderValidator implements ConstraintValidator<Gender, String> {
    private boolean required;

    @Override
    public void initialize(Gender constraintAnnotation) {
        // 获取到Gender的属性required的值，并赋值给本地变量
        this.required = constraintAnnotation.required();
    }

    /**
     * 是否校验通过
     * @param value 就是前端传递来进行数据校验的属性值
     * @param context
     * @return
     */
    @SneakyThrows
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (this.required) {
            return "男".equals(value) || "女".equals(value);
        }
        return true;
    }
}
