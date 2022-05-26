package com.controller;

import com.Params.PunchCardParams;
import com.service.EmployeeRecordService;
import com.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class PunchCardController {
    @Autowired
    EmployeeRecordService employeeRecordService;
    @PostMapping("punchcard")
    public Result punchCard(@RequestBody PunchCardParams punchCardParams){
        log.info(String.valueOf(punchCardParams));
        return employeeRecordService.punchCard(punchCardParams);
    }
    @PostMapping("afterwork")
    public Result afterWork(@RequestBody PunchCardParams punchCardParams){
        return employeeRecordService.afterWork(punchCardParams);
    }
}
