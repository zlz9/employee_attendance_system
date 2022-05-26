package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName employee
 */
@TableName(value ="employee")
@Data
public class Employee implements Serializable {
    /**
     * 员工id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工姓名
     */
    private Integer age;

    /**
     * 员工住址
     */
    private String address;

    /**
     * 手机号
     */
    private Integer phone;


    /**
     * 员工所属部门
     */
    private Long departmentId;
    private Long inductionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}