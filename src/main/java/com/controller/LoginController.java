package com.controller;

import com.Params.LoginParams;
import com.service.UserService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody LoginParams loginParams){
        return userService.login(loginParams);
    }

}
