package com.otto.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyBatis Plus的注解
 * 1. @TableName 应用在实体类上面，可以不添加，默认使用实体类的名字作为表名，并忽略大小写
 *       BaseMapper<User> 会根据泛型，即User，对应的表名user操作数据库
 *       在忽略大小写的前提下，当数据库的表名和实体类的名字不同时，必须使用@TableName注解指定的表名
 *       比如：表名是t_user，实体类的名字是User，此时使用注解@TableName("t_user")
 *       如果表太多，一个一个的添加@TableName很费时费力的时候，可以通过在配置文件中添加配置项来解决数据库的表名和实体类的名字不同的情况
 *       mybatis-plus.global-config.db-config.table-prefix=t_
 *
 * 2. @TableId 应用在实体类的属性上面，当主键的列名和实体类的属性名不一致时使用
 *          @TableId(value = "列名"，type = "主键策略") 主键策略就是数据库中如何生成主键值，比如自增, ...
 *              IdType.AUTO: 组件自增长，要求mysql数据库必须设置主键自增长 auto_increment
 *              IdType.ASSIGN_ID: 雪花算法，随机生成一个数字，给主键赋值，不会重复的。主要用于大数据或分布式数据
 *                                数据库的主键必须是 bigint / varchar(64) 类型
 *                                实体类的必须是Long或String类型
 *
 * 3. @TableField 指定数据库中的字段
 *      @TableField(value = "列名", exist = "表示是否存在与数据库中的某个列名一一对应")
 *
 * 4. @TableLogic 指定逻辑删除字段
 *          字段值为1表示逻辑删除，0表示未逻辑删除
 *          当删除数据的时候，自动变成修改此列的属性值
 *          当查询数据的时候，默认只查询deleted=0的记录
 *          同样可以配置全局的设置
 *              ## 指定逻辑删除的属性名
 *              mybatis-plus.global-config.db-config.logic-delete-field=deleted
 *              ## 指定逻辑删除字段的值为1是表示逻辑删除了
 *              mybatis-plus.global-config.db-config.logic-delete-value=1
 *              ## 指定逻辑删除字段的值为0是表示未逻辑删除了
 *              mybatis-plus.global-config.db-config.logic-not-delete-value=0
 *
 * ‼️‼️🈯️🈯️ 防全表的更新和删除的实现，即防止删库跑路
 *      interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
 */
@SpringBootApplication
public class MybatisPlus05AnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus05AnnotationApplication.class, args);
    }

}
