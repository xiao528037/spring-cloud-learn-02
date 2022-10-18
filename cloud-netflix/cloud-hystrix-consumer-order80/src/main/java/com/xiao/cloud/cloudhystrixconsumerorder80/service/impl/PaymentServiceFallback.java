package com.xiao.cloud.cloudhystrixconsumerorder80.service.impl;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudhystrixconsumerorder80.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-18 00:57:30
 * @description
 */
@Component
public class PaymentServiceFallback implements PaymentService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(0x10001L, "getPaymentById获取出现问题", null);
    }

    @Override
    public CommonResult getTimeout() {
        return new CommonResult<>(0x10001L, "超时了", null);
    }

    @Override
    public CommonResult addPayment(Payment payment) {
        return new CommonResult<>(0x10001L, "addPayment添加出现问题", null);
    }

    @Override
    public CommonResult circuitBreaker(Long id) {
        return new CommonResult<>(0x10001L, "断路器接口测试开启", null);
    }


}
