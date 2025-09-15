package com.otto.springmvc.controller;


import com.otto.springmvc.common.R;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * 声明式异常处理
 * 如果 Controller 类中出现异常，会首先在本类中找有没有 @ExceptionHandler 注解标注的方法
 * 如果有，则执行这个方法处理异常，这个方法执行的结果就是客户端收到的结果
 * 如果没有，会交给全局异常处理
 *
 * 如果有多个异常处理方法都能处理某一种类型的异常，则精确匹配的异常处理方法会优先执行的
 *
 * 如果出现了异常，本类和全局都不能处理，SpringBoot有兜底处理机制，浏览器会显示白页，客户端是json数据
 */
@RestController
public class ExceptionTestController {

    /**
     * 编程式异常处理
     * @return
     */
    @GetMapping("/exp1")
    public R programExceptionHandler() {

        // 编程式异常处理
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            return R.error(500, e.getMessage());

        }

        return R.ok();
    }


    /**
     *
     * @param i
     * @return
     */
    @GetMapping("/exp2")
    public R<Integer> declarativeExceptionHandler(@RequestParam("i") Integer i) throws FileNotFoundException {
        // ArithmeticException.class 类型的异常
        Integer j = 10 / i;
        // FileNotFoundException.class 类型的异常
        // FileInputStream fileInputStream = new FileInputStream("D://123");
        // NullPointerException.class 类型的异常
        String s = null;
        s.length();
        return R.ok(j);
    }


    /**
     * 声明式异常处理
     *
     * 专门处理 ExceptionTestController 类中的 ArithmeticException.class 类型的异常
     *
         {
         "code": 400,
         "msg": "/ by zero",
         "data": null
         }

     */
    @ExceptionHandler(value = ArithmeticException.class)
    public R ArithmaticExceptionHandler(Exception exp) {
        return R.error(400, exp.getMessage());
    }


    /**
     * 声明式异常处理
     *
     * 专门处理 ExceptionTestController 类中的 FileNotFoundException.class 类型的异常
     *
         {
         "code": 500,
         "msg": "D:/123 (No such file or directory)",
         "data": null
         }

     */
    @ExceptionHandler(value = FileNotFoundException.class)
    public R FileNotFoundExceptionHandler(Exception exp) {
        return R.error(300, exp.getMessage());
    }



    /**
     * 声明式异常处理
     *
     * 专门处理 ExceptionTestController 类中的 所有 类型的异常
     *


     */
    @ExceptionHandler(value = Throwable.class)
    public R ThrowableExceptionHandler(Throwable exp) {
        return R.error(500, exp.getMessage());
    }
}
