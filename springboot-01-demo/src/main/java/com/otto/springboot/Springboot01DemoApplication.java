package com.otto.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 环境隔离
 * 1. 定义环境，比如dev、test、prod
 * 2. 定义这个环境下哪些主键或配置生效
 *      i. 使用 @Profile("dev") 注解定义哪些组件在dev环境下生效
 *     ii. 在配置文件 application-dev.properties 中定义哪些配置是在dev环境下生效
 * 3. 激活这个环境，使得组件和配置生效
 *      i. 在 application.properties 中添加配置项 spring.profiles.active=dev 激活dev环境
 *     ii. 命令行 java -jar xxx.jar --spring.profiles.active=dev
 *
 * 生效的配置 = 默认的配置 + 激活的配置，即spring.profiles.active + 包含的配置，即spring.profiles.include
 * 激活优先级 高于 默认配置
 *
 *
 * 单元测试
 * @Test 表示测试方法是测试方法
 * @ParameterizedTest 表示方法是参数化测试
 * @RepeatedTest 表示方法可重复执行
 * @DisplayName 为测试类或测试方法设置展示的名称
 * @BeforeEach 表示在每一个单元测试之前执行
 * @AfterEach 表示在每一个单元测试之后执行
 * @BeforeAll 表示在所有的单元测试之前执行
 * @AfterAll 表示在所有的单元测试之后执行
 * @Tag 表示单元测试类别
 * @Disabled 表示测试类或测试方法不执行
 * @Timeout 表示测试方法运行超过了指定的时间将会返回错误
 * @ExtendWith 为测试类或测试方法提供扩展类的引用
 *
 * 单元测试的断言机制
 */
@EnableAsync // 开启基于注解的异步操作
@SpringBootApplication
public class Springboot01DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 这里通常写项目启动后的一次性任务
                // ... ...
            }
        };
    }

}
