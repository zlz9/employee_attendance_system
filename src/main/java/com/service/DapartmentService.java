package com.service;

import com.pojo.Dapartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;

/**
* @author 23340
* @description 针对表【dapartment】的数据库操作Service
* @createDate 2022-05-25 15:30:36
*/
public interface DapartmentService extends IService<Dapartment> {

    Result getDepatment();
}
