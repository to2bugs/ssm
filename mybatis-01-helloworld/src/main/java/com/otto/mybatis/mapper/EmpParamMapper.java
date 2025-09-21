package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 测试参数取值
 * 最佳实践，即使只有一个参数，也用 @Param 指定参数名
 */
@Mapper
public interface EmpParamMapper {

    /**
     * 单个参数，普通类型
     * 单个参数时，变量名可以随便写，比如xml文件中是变量abc 而mapper中使用的是id
     */
    Emp getEmploy(Integer id);

    /**
     * 单个参数，List类型
     *
     * 获取ids数组中，第二个元素指定的用户
     * 单个参数时，变量名可以随便写，比如xml文件中是变量abc 而mapper中使用的是ids
     * 单个参数且是数组类型时，xml文件中的变量abc[1]
     */
    Emp getEmploy02(List<Integer> ids);

    /**
     * 单个参数，对象类型
     * 单个参数时，且参数是对象时，xml文件中的变量就是参数对象的属性哦
     */
    void addEmploy(Emp emp);

    /**
     * 单个参数，Map类型
     * 单个参数时，且参数是Map时，xml文件中的变量就是Map的key
     */
    void addEmploy02(Map<String, Object> m);
}
