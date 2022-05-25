package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Department;
import com.service.DepartmentService;
import com.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 23340
* @description 针对表【department】的数据库操作Service实现
* @createDate 2022-05-24 14:59:39
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




