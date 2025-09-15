package com.otto.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 取不到值的时候使用默认值 ${cat.name:Tom} Tom就是默认值
 *
 * @PropertySource("classpath:cat.properties")
 *      说明属性来源，将指定文件cat.properties导入到容器中
 *      application.properties的优先级高于cat.properties
 *
 * 细节：
 *      classpath:cat.properties 扫描自己类路径下的文件
 *      classpath*:xxxx  扫描所有包的类路径下的某个文件
 */
@PropertySource("classpath:cat.properties")
@Component
@Data
public class Cat {
    @Value("${cat.name:Tom}")
    private String name;

    @Value("${cat.age:3}")
    private Integer age;
}
