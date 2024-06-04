package com.ZhiboYu.webquickstart.Controller;

import com.ZhiboYu.webquickstart.pojo.PageBean;
import com.ZhiboYu.webquickstart.pojo.Result;
import com.ZhiboYu.webquickstart.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
      log.info("分页查询，参数：{}, {}", page, pageSize);
      PageBean pageBean = empService.page(page, pageSize);
      return Result.success(pageBean);

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

}
