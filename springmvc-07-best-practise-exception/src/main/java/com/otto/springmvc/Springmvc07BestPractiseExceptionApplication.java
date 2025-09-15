package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 本地异常处理
 * 全局异常处理
 *
 * 前端关心异常的状态；
 * 后端只关心正确的业务流程，如果出现业务问题，通过抛出异常的方式提前中断业务逻辑，让前端感知异常
 *      中断业务逻辑的时候，必须让上层及以上的链路知道中断的原因，推荐抛出业务异常
 *
 * 异常处理的最终方式：
 * 1. 必须有业务异常类，比如BizException
 * 2. 必须有业务异常枚举类，比如BizExceptionEnum，列举每一个模块会出现的所有业务异常情况，即业务异常错误码和业务异常信息对应关系
 * 3. 编写业务代码的时候，只需要编写正确的逻辑，如果出现预期的问题，比如商品库存是否有，需要以抛异常的方式中断业务逻辑通知上层
 * 4. 定义全局异常处理器，处理所有的异常，包括系统异常和业务异常，返回给前端约定的json数据和错误码
 */
@SpringBootApplication
public class Springmvc07BestPractiseExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc07BestPractiseExceptionApplication.class, args);
    }

}
