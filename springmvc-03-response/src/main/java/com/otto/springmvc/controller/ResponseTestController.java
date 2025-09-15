package com.otto.springmvc.controller;
import com.otto.springmvc.bean.Address;
import java.util.ArrayList;

import com.otto.springmvc.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseTestController {

    /**
     * JavaBean 和 Map 的区别
     *  基本相同
     *  只是数据类型和个数，JavaBean 已经钉死了；如果没有确定的话使用Map
     */
    @RequestMapping("/resp01")
    public Person resp01() {
        Person person = new Person();
        person.setUsername("张三");
        person.setPassword("1234");
        person.setCellphone("567890");
        person.setAgreement(false);
        person.setAddress(new Address());
        person.setSex("男");
        person.setHobby(new String[]{"爱好1", "爱好2", "爱好3"});
        person.setGrade("三年级");

        return person;
    }
}
