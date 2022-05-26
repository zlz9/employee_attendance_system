package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Dapartment;
import com.service.DapartmentService;
import com.mapper.DapartmentMapper;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 23340
* @description 针对表【dapartment】的数据库操作Service实现
* @createDate 2022-05-25 15:30:36
*/
@Transactional
@Service
public class DapartmentServiceImpl extends ServiceImpl<DapartmentMapper, Dapartment>
    implements DapartmentService{
    @Autowired
    DapartmentMapper dapartmentMapper;
    @Override
    public Result getDepatment() {
        List<Dapartment> dapartments = dapartmentMapper.selectList(null);
        if (dapartments == null) {
            return Result.fail(405,"出现错误");
        }
        return Result.success(dapartments);
    }
}




