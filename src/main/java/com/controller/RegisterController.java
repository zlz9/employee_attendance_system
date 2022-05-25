package com.controller;

import com.Params.LoginParams;
import com.service.UserService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RegisterController {
    @Autowired
    UserService userService;
    @PostMapping("register")
    public Result register(@RequestBody LoginParams loginParams){
        return userService.register(loginParams);
    }
}
