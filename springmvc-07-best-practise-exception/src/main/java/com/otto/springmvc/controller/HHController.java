package com.otto.springmvc.controller;

import com.otto.springmvc.common.R;
import com.otto.springmvc.exception.BizException;
import com.otto.springmvc.exception.BizExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 因为本类中没有 @ExceptionHandler 注解标注的方法，所以出现异常时会继续的抛出异常给到SpringMVC
 * 此时可以使用全局异常类来处理这些异常的
 */
@RestController
public class HHController {

    /**
     * 业务逻辑错误，直接抛出
     */
    @GetMapping("/exp3")
    public void haha() {
        throw new BizException(BizExceptionEnum.ORDER_CLOSED);
    }

}
