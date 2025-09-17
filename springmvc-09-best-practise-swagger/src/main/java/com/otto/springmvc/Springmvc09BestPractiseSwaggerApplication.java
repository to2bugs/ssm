package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Swagger可以快速生成实时的接口文档，其遵循Open API规范
 * Knife4j是基于Swagger之上的增强套件
 * Knife4j https://doc.xiaominfo.com/docs/quick-start
 * 1, 导包
 *      knife4j-openapi3-jakarta-spring-boot-starter 4.4.0
 * 2，参见上面的网址，进行配置
 * 3, http://ip:port/doc.html 可以访问Knife4j提供的文档
 *    http://localhost:8080/swagger-ui/index.html 可以访问Swagger提供的文档
 * 4，使用注解
 *  @Tag: Controller类 描述controller的作用
 *  @Parameter: 参数 标识参数的作用
 *  @Schema: model层的JavaBean 描述模型作用即每个属性
 *  @Operation: 方法 描述方法的作用
 *
 *
 *  日期的处理时的报错
 *      JSON parse error: Cannot deserialize value of type `java.util.Date` from String "1975/12/30 13:30:00"
 *      with any of standard forms ("yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"))]
 *
 *      序列化：  后端查询到的日期对象 === 序列化 ===> 前端接受的日期字符串   默认的日期格式: 1975-09-16T06:12:49.000+00:00
 *      反序列化：前端提交日期字符串 === 反序列化 ===> 后端接受的日期对象  必须提交默认的日期格式，但可以修改哦
 *          通过 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 修改默认的日期格式为 yyyy-MM-dd HH:mm:ss，并指定时区
 *          参见：EmployeeAddVo、 EmployeeRespVo的birth属性
 */
@SpringBootApplication
public class Springmvc09BestPractiseSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc09BestPractiseSwaggerApplication.class, args);
    }

}
