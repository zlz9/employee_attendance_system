package com.service;

import com.Params.PunchCardParams;
import com.pojo.EmployeeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;

/**
* @author 23340
* @description 针对表【employee_record】的数据库操作Service
* @createDate 2022-05-25 17:02:57
*/
public interface EmployeeRecordService extends IService<EmployeeRecord> {

    Result punchCard(PunchCardParams punchCardParams);

    Result afterWork(PunchCardParams punchCardParams);
}
