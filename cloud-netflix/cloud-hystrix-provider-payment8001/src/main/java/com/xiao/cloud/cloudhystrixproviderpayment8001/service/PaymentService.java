package com.xiao.cloud.cloudhystrixproviderpayment8001.service;

import com.xiao.cloud.cloudcommon.common.CommonResult;
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

    /**
     * 添加
     * @param payment
     * @return
     */
    Payment addPayment(Payment payment);

    /**
     * hystrix超时请求测试
     * @return
     */
    CommonResult timeout();

    /**
     * 断路器配置
     * @param id
     * @return 返回结果
     */
    public CommonResult circuitBreaker(Long id) throws CloudException;
}
