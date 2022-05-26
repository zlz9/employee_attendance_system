package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dapartment
 */
@TableName(value ="dapartment")
@Data
public class Dapartment implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 部门
     */
    private String department;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}