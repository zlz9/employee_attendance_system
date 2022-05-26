package com.mapper;

import com.pojo.Dapartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author 23340
* @description 针对表【dapartment】的数据库操作Mapper
* @createDate 2022-05-25 15:30:36
* @Entity com.pojo.Dapartment
*/
@Mapper
public interface DapartmentMapper extends BaseMapper<Dapartment> {

}




