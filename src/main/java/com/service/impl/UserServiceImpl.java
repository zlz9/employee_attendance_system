package com.service.impl;

import com.Params.LoginParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 23340
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-24 14:59:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    /**
     * 登录接口
     * 1.对字符串进行判断
     * 2.查找用户
     * @param loginParams
     * @return
     */
    @Autowired
    UserMapper userMapper;
    @Override
    public Result login(LoginParams loginParams) {
        /**
         * 对输入的信息进行判断
         */
        if (loginParams.getNikeName()==null || loginParams.getPassword() == null) {
            return Result.fail(405,"请输入用户名和密码");
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,loginParams.getNikeName());
        queryWrapper.eq(User::getPassword,loginParams.getPassword());
        /**
         * 查找用户，返回用户
         */
        User user = userMapper.selectOne(queryWrapper);
        /**
         * 如果用户不存在返回错误信息
         */
        if (user == null) {
            return Result.fail(405,"用户不存在");
        }
        return Result.success(user);
    }

    @Override
    public Result register(LoginParams loginParams) {
        /**
         * 1.对参数进行判空
         * 2.查找数据库，
         * 如果有返回已存在，
         * 没有则插入
         */
        User insertUser = new User();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,loginParams.getNikeName());
        queryWrapper.eq(User::getPassword,loginParams.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            return Result.fail(405,"用户已经存在");
        }
        insertUser.setUsername(loginParams.getNikeName());
         insertUser.setPassword(loginParams.getPassword());
         userMapper.insert(insertUser);
        return Result.success(insertUser);
    }
}




