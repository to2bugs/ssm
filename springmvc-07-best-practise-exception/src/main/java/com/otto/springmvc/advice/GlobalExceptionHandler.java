package com.otto.springmvc.advice;


import com.otto.springmvc.common.R;
import com.otto.springmvc.exception.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  全局异常处理器
 *  Advice 还有一层意思是增强的意思
 *  @ControllerAdvice 表示对Controller进行增强，其实是增加了切面的机制，告诉SpringMVC这个组件负责全局异常的处理
 *
 *  ‼️因为最终是希望R对象是作为json数据写入到响应体内到，所以别忘了 @ResponseBody
 *  @ResponseBody + @ControllerAdvice = @RestControllerAdvice
 *
 *  如果有多个异常处理方法都能处理某一种类型的异常，则精确匹配的异常处理方法会优先执行的
 *
 *  如果出现了异常，本类和全局都不能处理，SpringBoot有兜底处理机制，浏览器会显示白页，客户端是json数据
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 专门处理全局数学运算的错误
    // @ResponseBody //
    @ExceptionHandler(value = {ArithmeticException.class})
    public R error1(Exception exp) {
        return R.error(300, exp.getMessage());
    }


    // 专门处理全局空指针的错误
    @ExceptionHandler(value = {NullPointerException.class})
    public R error2(Exception exp) {
        return R.error(400, exp.getMessage());
    }

    // 专门处理业务异常
    @ExceptionHandler(value = {BizException.class})
    public R bizException(BizException exp) {
        return R.error(exp.getCode(), exp.getMsg());
    }


    // 专门处理任意错误，做最终的兜底处理
    // @ResponseBody // ‼️因为最终是希望R对象是作为json数据写入到响应体内到，所以别忘了 @ResponseBody
    @ExceptionHandler(value = {Throwable.class})
    public R error3(Throwable exp) {
        return R.error(500, exp.getMessage());
    }
}
