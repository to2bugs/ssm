package com.otto.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @Autowired
    ApplicationContext ioc;

    /**
     *
     * @return String 默认返回值是跳到一个页面
     *      所以使用@ResponseBody，把返回值放入到响应体中
     *
     * @RequestMapping("路径")
     *      路径位置通配符：
     *          *：匹配0个或任意多个字符，但不能包括/
     *         **：匹配任意多层路径
     *          ?: 只能匹配单个字符，0个字符是不匹配的哦，有且只能匹配一个字符
     *      注意: 如果有多个都能够匹配，那么精确匹配的优先哦
     *      精确程度: 完全匹配 > ? > *
     *
     *      请求限定
     *          method：请求方式
     *          params：请求参数
     *          headers：请求头
     *          consumes：请求内容类型
     *          produces：响应内容类型
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Spring MVC! 你好！";
    }

    // ?: 匹配任意单个字符，0个字符是不匹配的哦，有且只能匹配一个字符
    @ResponseBody
    @RequestMapping("/hello?")
    public String handle01(HttpServletRequest request) {
        String pathInfo = request.getServletPath(); // /hellod
        String substring = pathInfo.substring("/hello".length());
        return "请求路径中?匹配" + substring;
    }

    // *：匹配0个或任意多个字符，但不能包括/
    @ResponseBody
    @RequestMapping("/hello*")
    public String handle02(HttpServletRequest request) {
        String pathInfo = request.getServletPath(); // /hellod
        String substring = pathInfo.substring("/hello".length());
        return "请求路径中*匹配" + substring;
    }

    // **：匹配任意多层路径
    @ResponseBody
    @RequestMapping("/hello/**")
    public String handle03(HttpServletRequest request) {
        String pathInfo = request.getServletPath(); // /hellod
        String substring = pathInfo.substring("/hello".length());
        return "请求路径中**匹配" + substring;
    }




}
