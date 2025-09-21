package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMultiParamMapper {

    /**
     * 多个参数，无@Param
     *
     * 新版本的MyBatis支持多个参数的情况下，字节使用 #{id} 和 #{name} 作为xml文件的参数
     * 但是老版本的MyBatis是不支持这样写得，需要使用 @Param 注解显示的定义xml文件中使用到的参数
     *
     * 多个参数，推荐使用@Param
     */
    Emp getEmployByIdAndName(@Param("empId") Integer id, @Param("empName") String name);

    /**
     *
     * @param id 获取到id
     * @param m 从map中获取到name
     * @param ids ids的第三个值是age
     * @param e 从e中获取到salary
     * @return
     */
    Emp getEmployFlux(
            @Param("id")  Integer id,
            @Param("ext") Map<String, Object> m,
            @Param("ids") List<Integer> ids,
            @Param("emp") Emp e
            );
}
