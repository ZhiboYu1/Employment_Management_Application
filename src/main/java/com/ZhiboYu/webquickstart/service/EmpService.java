package com.ZhiboYu.webquickstart.service;

import com.ZhiboYu.webquickstart.pojo.PageBean;
import com.ZhiboYu.webquickstart.pojo.Result;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
    void delete(List<Integer> ids);
}
