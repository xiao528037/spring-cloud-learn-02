package com.xiao.cloud.cloudhystrixproviderpayment8001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.cloud.cloudcommon.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:17:17
 * @description
 */

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
