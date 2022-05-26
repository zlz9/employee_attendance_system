package com.controller;

import com.service.DapartmentService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DepartmentController {
    @Autowired
    DapartmentService dapartmentService;
    @GetMapping("department")
    private Result getDepatment(){
        return dapartmentService.getDepatment();
    }
}
