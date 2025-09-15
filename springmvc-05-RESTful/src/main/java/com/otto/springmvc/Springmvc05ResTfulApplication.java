package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 使用资源名作为URI，使用HTTP的请求方法表示对资源的操作
 * GET /employee?id=1
 * POST /employee
 * PUT /employee
 * DELETE /employee/{id}
 * GET /employees
 * GET /employees/page
 *
 *
 * 统一返回R对象
 *      {
 *          "code": 200, // 业务状态码，200是成功，其余的都是失败；前端和后端商量不同的失败业务状态码都代表啥😧意思
 *          "msg": "错误消息", // 显示失败业务状态码的提示消息
 *          "data": 数据对象, // 服务器返回给前端的数据对象
 *      }
 *
 * CORS policy 同源策略，限制浏览器的ajax请求、图片、css、js，可以理解为浏览器“悄悄地”发送的请求
 * 跨资源共享(CORS)
 *      浏览器为了安全，默认会遵循同源策略，即请求要去的服务器和当前项目所在的服务器必须是同一个服务器，否则请求会被拦截
 *          简单理解为：URL的路径之前的部分，包括协议、域名、端口号，必须完全一致，否则请求会被拦截
 *
 * 解决方案：
 *  1. 前端解决
 *             复杂的跨域请求会发送两次：
 *                  1，Options请求，预检请求，浏览器会先发送options请求，询问服务器是否允许当前域名的前端页面发送ajax请求
 *                                  如果服务器允许，则会在响应头中添加Access-Controll-Allow-Origin = *
 *                  2，真正的请求
 *  2. 后端解决：即允许前端跨域，响应头中告诉浏览器此次跨域请求是允许的，Access-Controll-Allow-Origin = *
 *              SpringMVC的解决办法
 *                  在Controller的类上添加注解@CrossOrigin，则允许这个Controller类的所有方法都支持跨域请求
 *                  在Controller的类上的某个方法上添加注解@CrossOrigin，则允许这个Controller类的某个方法支持跨域请求
 */
@SpringBootApplication
public class Springmvc05ResTfulApplication {

    public static void main(String[] args) {

        SpringApplication.run(Springmvc05ResTfulApplication.class, args);
    }

}
