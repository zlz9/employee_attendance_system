package com.mapper;

import com.pojo.EmployeeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23340
* @description 针对表【employee_record】的数据库操作Mapper
* @createDate 2022-05-25 17:02:57
* @Entity com.pojo.EmployeeRecord
*/
@Mapper
public interface EmployeeRecordMapper extends BaseMapper<EmployeeRecord> {

}




