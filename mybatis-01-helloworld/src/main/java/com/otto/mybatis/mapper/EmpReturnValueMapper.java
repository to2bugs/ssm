package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 返回值 resultType
 * 基本类型: 比如 resultType="java.lang.Integer"
 *      MyBatis为java.lang下的很多数据类型都起了别名，只需要使用long、string、double等这些即可，不用写全类名
 * 对象: 比如 resultType="com.otto.mybatis.bean.Emp"
 * List: 返回集合，则写集合中的元素类型即可哦
 * Map: 写Map的value的类型，不要写java.util.Map
 *
 *
 * 实体类中的属性与数据库中的字段对应不上时，如何解决？？
 * 1，查询时使用别名
 * 2，开启MyBatis的驼峰命名
 * 3，使用resultMap自定义结果集
 * 最佳实践
 *   1. 开启MyBatis的驼峰命名
 *   2. 搞不定的，用自定义映射
 */
@Mapper
public interface EmpReturnValueMapper {

    /**
     * 返回基本类型
     */
    Integer countEmp();
    BigDecimal getEmpSalaryById(@Param("id") Integer id);

    /**
     * 返回Map，key是员工的id，value是每一个员工
     * 使用@MapKey指定返回Map的key对应哪个字段
     *
     * 有坑‼️
     * Map<Integer, Emp> employees中的value的类型不是Emp，而是HashMap
     * 如果xml文件中的 resultType="java.util.Map"，那么会在Emp emp = employees.get(1)处报错
     * ‼️class java.util.HashMap cannot be cast to class com.otto.mybatis.bean.Emp
     * 重要‼️要在xml文件中将resultType修改为
     *
     */
    @MapKey("id")
    Map<Integer, Emp> getAllEmployee();


    /**
     * 默认规则：使用resultType，Java Bean中的属性名去数据库中找对应的列名的值，有就赋值，没有就赋值null
     * 自定义规则：使用resultMap，告诉MyBatis如何将结果封装到Java Bean中
     */
    Emp getEmpById01(@Param("id") Integer id);
}
