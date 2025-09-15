package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 数据校验JSR303
 * 1. 首先引入 spring-boot-starter-validation
 * 2. 在Bean的属性上添加，比如@NotBlank @Max ...，参见Employee
 * 3. 通常在Controller的某个方法的参数中添加 @Valid，参见EmployeeRestfulController类的方法add()
 *    并在@Valid修饰的参数后，紧跟一个BindingResult参数，用来封装校验结果的，但是这样写不好
 *    因为校验失败，是会抛出 MethodArgumentNotValidException 异常的
 *    而 MethodArgumentNotValidException 异常，则可以在全局异常处理中捕获到
 * 4. 编写全局异常处理，@ExceptionHandler(value = MethodArgumentNotValidException.class)
 * 5. 自定义校验 = 自定义校验注解 + 自定义校验器
 *
 * 校验失败后，业务就不会继续执行了，同时会被全局异常处理器捕捉到
 *
 *
 * 自定义校验器
 *  比如定义 @Gender 注解
 */
@SpringBootApplication
public class Springmvc08BestPractiseValidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc08BestPractiseValidateApplication.class, args);
    }

}
