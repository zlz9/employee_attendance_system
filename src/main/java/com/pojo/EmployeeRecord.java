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
 * @TableName employee_record
 */
@TableName(value ="employee_record")
@Data
public class EmployeeRecord implements Serializable {
    /**
     * 员工id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 所属部门
     */
    private Long departmentId;

    /**
     * 工作时间
     */
    private Long startime;

    /**
     * 下班时间
     */
    private Long endtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}