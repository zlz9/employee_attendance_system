package com.service;

import com.Params.LoginParams;
import com.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;

/**
* @author 23340
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-24 14:59:39
*/
public interface UserService extends IService<User> {

    Result login(LoginParams loginParams);

    Result register(LoginParams loginParams);
}
