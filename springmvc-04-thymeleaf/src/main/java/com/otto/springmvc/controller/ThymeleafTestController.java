package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @RestController 处理前后端分离，即后端返回json数据
 * @Controller 后端返回的是一个模板页面
 */
@Controller// 开发服务端渲染
public class ThymeleafTestController {

    /**
     * 处理 / 请求，并跳转到 /login
     *
     * @Return 返回值就是页面名称
     */
    @RequestMapping("/")
    public String index() {

        // thymleaf默认会去找 "src/main/resources/templates/" + login + ".html" 页面
        return "login";
    }


    /**
     * 处理登陆请求
     *
     * Model 模型就是页面要展示的所有数据
     */
    @RequestMapping("/login.do")
    public String login(
            @RequestParam("username") String name,
            @RequestParam("password") String pwd,
            Model model
    ) {
        // 在模型中放入数据
        model.addAttribute("username", name);
        model.addAttribute("password", pwd);
        model.addAttribute("age", 18);
        model.addAttribute("visitors", Arrays.asList(
                new Person(1, "张三",18),
                new Person(2, "李四",28),
                new Person(3, "王五",34),
                new Person(4, "麻子",8)
        ));
        // 跳转到页面
        return "page/success";
    }
}
