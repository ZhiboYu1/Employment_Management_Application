package com.ZhiboYu.webquickstart.service.impl;

import com.ZhiboYu.webquickstart.mapper.DeptMapper;
import com.ZhiboYu.webquickstart.pojo.Dept;
import com.ZhiboYu.webquickstart.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }
    @Override
    public void delete(Integer id){
        deptMapper.deleteById(id);
    }

    /**
     * 新增部门
     *
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());//dept表中有create_time，update_time两列，所以要补上
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
    @Override
    public Dept search(Integer id){
        return deptMapper.searchById(id);
    }

}
