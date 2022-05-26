package com.service.impl;

import com.Params.InductionParams;
import com.Params.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.DapartmentMapper;
import com.mapper.EmployeeRecordMapper;
import com.pojo.Employee;
import com.pojo.EmployeeRecord;
import com.service.EmployeeService;
import com.mapper.EmployeeMapper;
import com.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
* @author 23340
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2022-05-25 15:30:36
*/
@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{
    /**
     * 分页查询所有员工打卡信息
     * @param pageParams
     * @return
     */
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DapartmentMapper dapartmentMapper;
    @Autowired
    EmployeeRecordMapper employeeRecordMapper;
    @Override
    public Result EmployeeData(PageParams pageParams) {
        Page<EmployeeRecord> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<EmployeeRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(EmployeeRecord::getStartime);
        Page<EmployeeRecord> employeePage = employeeRecordMapper.selectPage(page, queryWrapper);
        List<EmployeeRecord> records = employeePage.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        /**
         * 根据部门id查找部门
         */
        map.put("data",records);
        map.put("total",page.getTotal());
        return Result.success(map);
    }

    /**
     * 员工注册
     * @param inductionParams
     * @return
     */
    @Override
    public Result induction(InductionParams inductionParams) {
        if (inductionParams == null) {
            return Result.fail(405,"参数错误");
        }
        Employee employee = new Employee();
        employee.setAddress(inductionParams.getAddress());
        employee.setEmpName(inductionParams.getEmpName());
        employee.setPhone(inductionParams.getPhone());
        employee.setAge(inductionParams.getAge());
        employee.setDepartmentId(inductionParams.getDepartment());
        employee.setInductionTime(System.currentTimeMillis());
        int insertEmp = employeeMapper.insert(employee);
        return Result.success(insertEmp);
    }

    /**
     * 获取员工信息
     * @return
     */
    @Override
    public Result empInfo(PageParams pageParams) {
        Page<Employee> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Employee::getId);
        Page<Employee> employeePage = employeeMapper.selectPage(page, queryWrapper);
        List<Employee> records = employeePage.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",records);
        map.put("total",page.getTotal());
        return Result.success(map);
    }

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    @Override
    public Result empDelete(Long id) {
        if (id == null) {
            return Result.fail(405,"参数错误");
        }
        int empDelete = employeeMapper.deleteById(id);
        return Result.success(empDelete);
    }
}




