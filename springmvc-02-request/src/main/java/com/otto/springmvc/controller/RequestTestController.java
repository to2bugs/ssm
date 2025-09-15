package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;

/**
 * 以下的所有请求不是GET就是POST，而且带的参数要么在GET方法的URL后拼接，要么在POST方法的请求体中
 * 但是不管怎样，请求的参数都是key1=value1&key2=value2&key3=value3的形式
 *
 * 注意：只要请求数据不是json格式的字符串，就可以使用@RequestParam注解
 */
@Slf4j
@RestController
public class RequestTestController {

    /**
     * 使用普通变量，收集请求参数，变量名必须与参数名一致哦
     *      ?username=otto&password=ddd&cellphone=ee&agreement=on
     *
     * 情况一: ?username=otto&password=&cellphone=123456
     *      包装类型，比如password，会自动封装为null
     *      非包装类型，比如agreement，则不会携带在查询字符串中，则基本类型会自动封装成默认值，比如false
     */
    @GetMapping("/handle01")
    public String handle01(
            String username, String password,
            String cellphone, boolean agreement
    ) {
        log.info("username: {}, password: {}, cellphone: {}, agreement: {}", username, password, cellphone, agreement );
        return "handler01";
    }


    /**
     *
     * 使用@RequestParam，逐一封装多个参数
     * ?username=otto&password=1234&cellphone=345&agreement=on
     * ！！！不论查询字符串是在url中，或者是在请求体中，都可以使用@RequestParam获取到的
     * 注意事项：使用@RequestParam标注的参数对应的变量名，一定要出现在查询字符串中，否则会爆错的
     *         也可以使用@RequestParam的属性required = false，显示的非必要携带在查询字符串中
     *
     *         包装类型，比如phone，在查询字符串中是cellphon=，则会自动封装为null，但可以通过@RequestParam的default属性设置默认值
     *         非包装类型，比如agreement，则不会携带在查询字符串中，则基本类型会自动封装成默认值，比如false
     */
    @GetMapping("/handle02")
    public String handle02(
            @RequestParam String username,
            @RequestParam("password") String pwd,
            @RequestParam(value = "cellphone", required = false, defaultValue = "123456")String phone,
            @RequestParam(value = "agreement", required = false) boolean agreement
    ) {
        log.info("username: {}, password: {}, cellphone: {}, agreement: {}", username, pwd, phone, agreement );
        return "handle02";
    }


    /**
     * 使用POJO，统一封装多个参数
     * Post
     *  content-type: application/x-www-form-urlencoded
     *  请求体: username=otto&password=123&cellphone=13908651234&agreement=on
     *
     *  Pojo的所有属性值都来自于请求参数
     *  如果请求参数中某个参数没有携带，则封装为null
     */
    @PostMapping("/handle03")
    public String handle03(
        Person person
    ) {
        System.out.println(person);
        return "handle03";
    }



    /**
     * 使用POJO，级联封装复杂对象
     *
     *  ?username=otto&password=1234&cellphone=5678&address.province=ah&address.city=hf&address.area=ly&sex=%E7%94%B7&hobby=%E8%B6%B3%E7%90%83&hobby=%E7%AF%AE%E7%90%83&hobby=%E4%B9%92%E4%B9%93%E7%90%83&grade=%E4%BA%8C%E5%B9%B4%E7%BA%A7&agreement=on
     */
    @GetMapping("/handle06")
    public String handle06(
        Person person
    ) {
        System.out.println(person);
        return "handle06";
    }


    /**
     * HttpEntity: 封装请求头、请求体，获得整个请求
     *  泛型是请求体中的数据类型，这里既可以是String, 更通用一些；也可以是Person，因为请求体中的数据就是Person对象的JSON字符串
     *  与请求方法无关，既可以是GET方法，也可以是POST方法
     */
    @RequestMapping("/handle09")
    public String handle09(
            HttpEntity<String> entity
    ) {
        // System.out.println("entity = " + entity);
        // 1, 获取到所有的请求头
        HttpHeaders headers = entity.getHeaders();
        System.out.println(headers);
        // 2, 获取到请求体
        String body = entity.getBody();
        System.out.println(body);
        return "handle09";
    }
}
