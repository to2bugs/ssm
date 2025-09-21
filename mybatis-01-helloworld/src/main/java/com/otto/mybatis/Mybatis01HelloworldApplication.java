package com.otto.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis的使用：
 * 1，导入mybatis的依赖坐标
 * 2，配置信息源
 * 3. 编写一个JavaBean，对应数据库中的一个表模型
 * 4. 以前是编写Dao接口，对应一个Dao的实现；
 *    现在只要定义Mapper接口,使用@Mapper注解，并编写一个Mapper.xml即可，其中配置方法的实现sql
 * 5. 告诉mybatis,mapper文件在哪里
 */
@EnableTransactionManagement // 开启事务
@SpringBootApplication
public class Mybatis01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis01HelloworldApplication.class, args);
    }

}
