package com.ZhiboYu.webquickstart.Controller;

import com.ZhiboYu.webquickstart.pojo.Dept;
import com.ZhiboYu.webquickstart.pojo.Result;
import com.ZhiboYu.webquickstart.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){//加上requestBody
        log.info("新增部门： {}", dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id){
        log.info("根据id查询部门：{}", id);
        Dept dept = deptService.search(id);
        return Result.success(dept);
    }
}
