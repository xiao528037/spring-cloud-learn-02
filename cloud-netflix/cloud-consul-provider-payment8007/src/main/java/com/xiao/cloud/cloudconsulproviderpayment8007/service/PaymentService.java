package com.xiao.cloud.cloudconsulproviderpayment8007.service;

import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:20:33
 * @description
 */
public interface PaymentService {
    /**
     * 通过id查询payment
     *
     * @param id
     * @return 返回信息
     */
    Payment selectById(Long id) throws CloudException;

    Payment addPayment(Payment payment);
}
