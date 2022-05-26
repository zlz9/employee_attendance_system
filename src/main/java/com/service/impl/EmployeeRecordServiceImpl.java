package com.service.impl;

import com.Params.PunchCardParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import com.pojo.EmployeeRecord;
import com.service.EmployeeRecordService;
import com.mapper.EmployeeRecordMapper;
import com.utils.Result;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.NumberUtils;

/**
* @author 23340
* @description 针对表【employee_record】的数据库操作Service实现
* @createDate 2022-05-25 17:02:57
*/
@Transactional
@Service
public class EmployeeRecordServiceImpl extends ServiceImpl<EmployeeRecordMapper, EmployeeRecord>
    implements EmployeeRecordService{
    /**
     * 功能：打卡
     * 1.根据传过来的用户名查询员工信息
     * 2.如果有返回成功，没有返回失败
     * 3.对打卡表进行插入
     * @param punchCardParams
     * @return
     */
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeRecordMapper employeeRecordMapper;
    @Override
    public Result punchCard(PunchCardParams punchCardParams) {
        /**
         * 对参数进行判空
         */
        if (punchCardParams == null) {
            return Result.fail(406,"参数错误");
        }
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
         queryWrapper.eq(Employee::getEmpName, punchCardParams.getEmployeeName());
        /**
         * 根据名字查找用户
         */
        Employee emp = employeeMapper.selectOne(queryWrapper);
        if (emp == null) {
            return Result.fail(405,"用户不存在，请先注册或联系管理员");
        }
        /**
         * 根据用户名查找
         */
        EmployeeRecord employeeRecord = new EmployeeRecord();
        employeeRecord.setEmployeeName(emp.getEmpName());
        employeeRecord.setDepartmentId(emp.getDepartmentId());
        employeeRecord.setStartime(System.currentTimeMillis());
        /**
         * 将信息插入记录表
         */
        int record = employeeRecordMapper.insert(employeeRecord);
        return Result.success(record);
    }

    /**
     * 打卡下班模块
     * 1.对参数做判断
     * 2.根据名字查询员工信息
     * 3.查到了就继续执行，没有查到就返回失败
     * 4.查到了就对用户信息进行下班打卡更新
     * @param punchCardParams
     * @return
     */
    @Override
    public Result afterWork(PunchCardParams punchCardParams) {
        if (StringUtils.isBlank(punchCardParams.getEmployeeName())) {
            return Result.fail(405,"参数错误");
        }
        LambdaQueryWrapper<EmployeeRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EmployeeRecord::getEmployeeName,punchCardParams.getEmployeeName()).orderByDesc(EmployeeRecord::getStartime).last("limit 1");
        EmployeeRecord employeeRecord = employeeRecordMapper.selectOne(queryWrapper);
        if (employeeRecord == null) {
            return Result.fail(406,"该用户不存在");
        }
        employeeRecord.setEndtime(System.currentTimeMillis());
        int updateRecord = employeeRecordMapper.updateById(employeeRecord);
        return Result.success(updateRecord);
    }
}




