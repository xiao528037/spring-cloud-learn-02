package com.xiao.cloud.cloudcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:14:41
 * @description
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;

    @TableField(exist = false)
    private String testNull;
}