package com.service;

import com.Params.InductionParams;
import com.Params.PageParams;
import com.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;

/**
* @author 23340
* @description 针对表【employee】的数据库操作Service
* @createDate 2022-05-25 15:30:37
*/
public interface EmployeeService extends IService<Employee> {

    Result EmployeeData(PageParams pageParams);

    Result induction(InductionParams inductionParams);

    Result empInfo(PageParams pageParams);

    Result empDelete(Long id);
}
