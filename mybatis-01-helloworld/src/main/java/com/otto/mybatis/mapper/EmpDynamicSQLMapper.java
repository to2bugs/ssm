package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface EmpDynamicSQLMapper {

    // 按照 empName 和 empSalary 查询员工，<when> 、 <trim> 和 <choose-when-otherwise>
    List<Emp> selectEmpByNameOrSalary(@Param("name") String name, @Param("salary") BigDecimal salary);
    List<Emp> selectEmpByNameOrSalaryTrim(@Param("name") String name, @Param("salary") BigDecimal salary);
    List<Emp> selectEmpByNameOrSalaryWhen(@Param("name") String name, @Param("salary") BigDecimal salary);

    // 更新用户: 带了哪些属性，就只更新这些带了的属性，其余属性不会变化的，<when> 和 <trim>
    void updateEmp(Emp emp);
    void updateEmpTrim(Emp emp);

    // 查询ids范围中的所有员工
    List<Emp> getEmpsByIds(@Param("idList") List<Integer> ids);

    // 批量的插入员工
    /*
        insert into t_emp (emp_name, age, emp_salary)
        values (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?) , (?, ?, ?)
     */
    void addEmps(@Param("empList") List<Emp> emps);


    // 批量修改员工
    // MySql默认是不支持批量多个sql的，需要允许多个sql用分号;隔开，批量发送给数据库执行
    // jdbc:mysql//mybatis-example?allowMultiQueries=true
    /*
        update t_emp set emp_name = '...' where id = '...';
        update t_emp set emp_name = '...' where id = '...';
        update t_emp set emp_name = '...' where id = '...';
        ...
     */
    // void updateBatchEmps(@Param("idList") List<Integer> ids);
    @Transactional(rollbackFor = Exception.class)
    void updateBatchEmps01(@Param("empList") List<Emp> emps);
}
