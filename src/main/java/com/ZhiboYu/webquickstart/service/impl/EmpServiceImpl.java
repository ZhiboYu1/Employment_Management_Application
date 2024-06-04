package com.ZhiboYu.webquickstart.service.impl;

import com.ZhiboYu.webquickstart.mapper.EmpMapper;
import com.ZhiboYu.webquickstart.pojo.Emp;
import com.ZhiboYu.webquickstart.pojo.PageBean;
import com.ZhiboYu.webquickstart.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize){
//        Long count = empMapper.count();
//        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);
//        return new PageBean(count, empList);
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids){
        empMapper.delete(ids);
    }
}
