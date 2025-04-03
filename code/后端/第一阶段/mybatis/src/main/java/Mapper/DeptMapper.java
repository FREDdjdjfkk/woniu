package Mapper;

import org.apache.ibatis.annotations.*;
import pojo.Dept;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {
    /**根据id查询部门信息*/
    @Select("select * from department where id = #{id};")
    Dept findById(Integer id);
    @Select("select * from department;")
    /**根据查询所有部门数据*/
    List<Dept> findAll();
    //pojo传参
    @Insert("insert into  department values (#{id}, #{name}, #{companyId}, now(), #{number}) ")
    /**新增部门信息*/
    void insetDept(Dept dept);

    //@param注解传参
    @Update("update department set name=#{name} where id=#{id};")
    /**根据id修改指定部门名称和地址*/
    void updateDept(@Param("name")String name, @Param("id")int id);

    @Delete("delete from department where id = #{id}")
    /**根据id删除指定部门信息*/
    void deleteDept(Map<String,Object> map);


    List<Dept> findCondition(Dept dept);
}
