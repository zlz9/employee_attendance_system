package com.controller;

import com.Params.InductionParams;
import com.service.EmployeeService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工入职模块
 */
@RestController
@RequestMapping
public class EmployeeInductionController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("induction")
    public Result induction(@RequestBody InductionParams inductionParams){
          return employeeService.induction(inductionParams);
    }
}
