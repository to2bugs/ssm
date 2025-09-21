package com.otto.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.otto.mybatis.bean.Emp;
import com.otto.mybatis.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询 所有的员工
     * @return
     */
    // public List<Emp> getEmpList(Integer pageNumber, Integer pageSize) {
    //     PageHelper.startPage(pageNumber, pageSize);
    //     // 只有紧跟着 startPage() 之后的方法就会执行SQL分页操作哦
    //     List<Emp> emps = empMapper.getAllEmpWithPage();
    //     return emps; // 获得的就是分页后的数据了
    // }
    // 前端需要的数据：
    // 1，总页码、总记录数
    // 2，当前页码
    // 3，本页的数据
    public PageInfo<Emp> getEmpList(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Emp> emps = empMapper.getAllEmpWithPage();
        // 要满足前端需要的数据，只要修改成下面的写法
        PageInfo<Emp> page = new PageInfo<>(emps);
        return page; // 直接返回PageInfo的对象即可
    }
}
