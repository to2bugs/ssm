package com.otto.springmvc.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HeaderAndCookieTestController {

    /**
     * 使用@RequestHeader获取请求头数据
     */
    @GetMapping("/handle04")
    public String handle04(
            @RequestHeader("Accept") String Accept,
            @RequestHeader Map<String, String> headers
    ) {
        System.out.println(Accept);
        System.out.println(headers);
        return "handle04";
    }


    /**
     * 使用@CookieValue获取Cookie数据
     */
    @GetMapping("/handle05")
    public String handle05(
            @CookieValue("haha") String haha
    ) {
        System.out.println(haha);
        return "handle05";
    }
}
