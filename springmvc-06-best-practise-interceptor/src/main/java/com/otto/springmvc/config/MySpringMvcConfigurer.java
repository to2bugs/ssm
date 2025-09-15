package com.otto.springmvc.config;


import com.otto.springmvc.interceptor.AAAInterceptor;
import com.otto.springmvc.interceptor.BBBInterceptor;
import com.otto.springmvc.interceptor.CCCInterceptor;
import com.otto.springmvc.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 专门对SpringMVC底层做一些配置
 *  只需要在容器中放 WebMvcConfigurer 组件即可
 *  1. 通过 @Bean 放一个 WebMvcConfigurer 组件
 *  2. 通过继承 implements WebMvcConfigurer
 */
@Configuration
public class MySpringMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    @Autowired
    AAAInterceptor aaaInterceptor;

    @Autowired
    BBBInterceptor bbbInterceptor;

    @Autowired
    CCCInterceptor cccInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**"); // 拦截所有的请求

        // registry.addInterceptor(aaaInterceptor).addPathPatterns("/**");
        // registry.addInterceptor(bbbInterceptor).addPathPatterns("/**");
        // registry.addInterceptor(cccInterceptor).addPathPatterns("/**");
    }
}
