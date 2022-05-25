package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Emp;
import com.service.EmpService;
import com.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author 23340
* @description 针对表【emp】的数据库操作Service实现
* @createDate 2022-05-24 14:59:39
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




