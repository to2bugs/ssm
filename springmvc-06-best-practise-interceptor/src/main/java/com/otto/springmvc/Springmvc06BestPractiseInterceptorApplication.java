package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 拦截器
 *      SpringMVC内置的拦截器
 *      使用步骤:
 *      1️⃣实现 HandlerInteceptor 接口的组件即可成为拦截器
 *      2️⃣创建 WebMvcConfigurer 组件，并配置拦截器的拦截路径
 *      3️⃣查看执行顺序: preHandle ➡️ 目标方法 ➡️ postHandle ➡️ afterCompletion
 *        只有执行成功的 preHandle 才会倒叙执行 afterCompletion
 *        postHandle 和 after
 *
 * 多拦截器的执行顺序
 *    正常执行顺序
 *      AAAInterceptor ... preHandle
 *      BBBInterceptor ... preHandle
 *      CCCInterceptor ... preHandle
 *
 *      CCCInterceptor ... postHandle
 *      BBBInterceptor ... postHandle
 *      AAAInterceptor ... postHandle
 *
 *      CCCInterceptor ... afterCompletion
 *      BBBInterceptor ... afterCompletion
 *      AAAInterceptor ... afterCompletion
 *
 *   非正常执行顺序: BBBInterceptor的preHandle返回false
 *      AAAInterceptor ... preHandle
 *      BBBInterceptor ... preHandle
 *      AAAInterceptor ... afterCompletion
 *
 *   非正常执行顺序: BBBInterceptor的postHandle抛出异常
 *      AAAInterceptor ... preHandle
 *      BBBInterceptor ... preHandle
 *      CCCInterceptor ... preHandle
 *
 *      CCCInterceptor ... postHandle
 *      BBBInterceptor ... postHandle  炸了
 *
 *      CCCInterceptor ... afterCompletion
 *      BBBInterceptor ... afterCompletion
 *      AAAInterceptor ... afterCompletion
 *
 *
 *
 *   preHandler返回true后，afterCompletion才会执行
 *   postHandle是controller方法执行之后
 *
 *
 */
@SpringBootApplication
public class Springmvc06BestPractiseInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc06BestPractiseInterceptorApplication.class, args);
    }

}
