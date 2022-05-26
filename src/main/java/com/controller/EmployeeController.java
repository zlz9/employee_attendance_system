package com.controller;

import com.Params.PageParams;
import com.service.EmployeeService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {
@Autowired
    EmployeeService employeeService;
/**
 * 查询所有的员工打卡信息
 */
@GetMapping("employee")
public Result EmployeeData( PageParams pageParams){
    return employeeService.EmployeeData(pageParams);
}
@GetMapping("emp/infomation")
    public Result empInfo(PageParams pageParams){
    return employeeService.empInfo(pageParams);
}
@PostMapping("emp/delete")
    public Result empDelete(Long id){
    return employeeService.empDelete(id);
}
}
