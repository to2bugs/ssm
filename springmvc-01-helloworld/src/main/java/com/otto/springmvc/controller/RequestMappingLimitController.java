package com.otto.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
 *          consumes：服务端要求请求内容类型，可以理解为客户端生产数据，服务端获得数据即消费数据，指定服务端要消费什么样MediaType类型的数据
 *          produces：响应内容类型
 */
@RestController
public class RequestMappingLimitController {

    /**
     * 请求方式：GET、HEAD、POST、PUT、PATCH、DELETE
     * @return
     */
    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public String test01() {
        return "method: POST";
    }





    /**
     * 请求参数：params = {"", "", ...}
     * 1, {"username"}：表示请求必须包含username参数名
     * 2, {"age"=18}: 表示参数age=18必须存在
     * 3, {"age=18", "username", "gender!=1"}:
     *      必须有名为age的参数且其值必须是18，且必须有名为username的参数，且参数gender的值不能等于1或者没有gender这个参数
     *
     * http://localhost:8080/test02?username=otto&age=18&gender=0
     */
    @RequestMapping(value = "/test02", method = RequestMethod.GET, params = {"age=18", "username", "gender!=1"})
    public String test02(HttpServletRequest request) {
        return "params: " + request.getQueryString();
    }





    /**
     * 请求头： headers = {"", "", ...}
     *  使用情况类似于 params
     *  1. {"haha"}: 表示请求头中必须包含haha这个key
     *  2. {"hehe != 1"}: 表示请求头中没有hehe这个key，或者有hehe这个key且其值必须不能是1
     */
    @RequestMapping(value = "/test03", headers = {"haha"})
    public String test03(HttpServletRequest request) {
        return "请求头中的参数: " + request.getHeader("haha") + " " + request.getHeader("hehe");
    }


    /**
     * 服务端要求请求内容类型，可以理解为客户端生产数据，服务端获得数据即消费数据，指定服务端要消费什么样MediaType类型的数据
     * 参见org.springframework.http.MediaType
     * 1. "application/json": 表示浏览器必须携带JSON格式的字符串
     */
    @RequestMapping(value = "/test04", consumes = {"application/json"})
    public String test04(HttpServletRequest request) {
        return "consumes";
    }




    /**
     *
     */
    @RequestMapping(value = "/test05", produces = MediaType.TEXT_HTML_VALUE)
    public String test05(HttpServletRequest request) {
        return "<h2>你好啊</h2>";
    }
}
