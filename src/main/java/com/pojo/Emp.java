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
 * @TableName emp
 */
@TableName(value ="emp")
@Data
public class Emp implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Date birthday;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer cellphone;

    /**
     * 
     */
    private Long depId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}