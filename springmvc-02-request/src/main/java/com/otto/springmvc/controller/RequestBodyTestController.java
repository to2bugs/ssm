package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接受JSON数据，使用@RequestBody,
 * @RequestBody: 获取请求体的json数据，并自动的转为Person对象
 */
/*
        {
            "username": "otto",
            "password": "1234",
            "cellphone": "567890",
            "agreement": true,
            "address": {
                "province": "anhui",
                "city": "hefei",
                "area": "luyang"
            },
            "sex": "男",
            "hobby": ["足球","篮球","乒乓球"],
            "grade": "欧坤"
        }
 */
@RestController
public class RequestBodyTestController {

    /**
     * 既可以 @RequestBody Person person 将请求数据封装到Person的对象中
     * 也可以 @RequestBody String data 直接接受请求数据json格式的字符串
     *
     */
    @PostMapping("/handle07")
    public String handle07(
        // @RequestBody Person person,
        @RequestBody String data
    ) {
        // System.out.println("person = " + person);
        System.out.println("data = " + data);
        return "handle07";
    }
}
