package com.mapper;

import com.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23340
* @description 针对表【emp】的数据库操作Mapper
* @createDate 2022-05-24 14:59:39
* @Entity com.pojo.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}




