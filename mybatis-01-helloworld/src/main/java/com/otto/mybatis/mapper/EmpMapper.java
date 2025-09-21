package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ioc容器会为每一个Mapper接口创建代理对象，之后@Autowired自动注入的就是这个代理对象
 * @Param("abc") 定义sql语句中的参数 #{abc}
 */
@Mapper
public interface EmpMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Emp getEmpById(@Param("abc") Integer id);

    /**
     * 添加
     * @param emp
     *  ‼️‼️‼️ 通过useGeneratedKeys="true"，获取自增的ID；并通过 keyProperty="id" 设置emp对象接受这个自增值的字段 ‼️‼️‼️
     */
    void addEmp(@Param("employee") Emp emp);


    /**
     * 更新
     * @param emp
     */
    void updateEmp(Emp emp);


    /**
     * 根据id删除
     * @param id
     */
    void deleteEmpById(@Param("empId") Integer id);


    /**
     * 查询所有员工信息
     * @return
     */
    List<Emp> getAllEmp();


    /**
     * 分辨#{}与${}的区别
     * ${}: 是把参数值直接拼接在sql语句中，是拼接的方式，可以能回出现sql注入的问题不安全⚠️
     *          但也不是一无是处，比如在sql语句中表名字不确定时，只能使用${}进行拼接，而不是#{}，如下面的方法
     *          JDBC层面，比如表名字等位置，不支持预编译的，只能使用${}进行拼接
     * #{}: 是把参数当作额外的parameters进行传递的，sql语句中依然使用占位符'?'，是预编译的方式
     * @param id
     * @return
     */
    Emp getEmpById2(@Param("empId") Integer id, @Param("tn") String tableName);


    /**
     * 分页查询所有的员工
     */
    List<Emp> getAllEmpWithPage();
}
