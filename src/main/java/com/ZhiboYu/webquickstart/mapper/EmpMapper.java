package com.ZhiboYu.webquickstart.mapper;

import com.ZhiboYu.webquickstart.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public long count();
//
//    /**
//     * 分页查询，获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
    @Select("select * from emp")
    public List<Emp> list();
    void delete(List<Integer> ids);
}
