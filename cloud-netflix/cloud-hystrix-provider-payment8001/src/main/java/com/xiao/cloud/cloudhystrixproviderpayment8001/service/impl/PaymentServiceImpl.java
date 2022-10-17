package com.xiao.cloud.cloudhystrixproviderpayment8001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.common.FallBackCommon;
import com.xiao.cloud.cloudcommon.common.ResultCode;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import com.xiao.cloud.cloudhystrixproviderpayment8001.mapper.PaymentMapper;
import com.xiao.cloud.cloudhystrixproviderpayment8001.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:21:01
 * @description
 */
@Service("paymentService")
@DefaultProperties(defaultFallback = "testFallback")
public class PaymentServiceImpl implements PaymentService {

    public PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }


    @Override
    public Payment selectById(Long id) throws CloudException {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Payment payment = paymentMapper.selectOne(queryWrapper);
        if (payment == null) {
            throw new CloudException(ResultCode.FAIL);
        }
        return payment;
    }

    @Override
    public Payment addPayment(Payment payment) {
        paymentMapper.insert(payment);
        return paymentMapper.selectById(payment.getId());
    }

    @Override
    @HystrixCommand(commandProperties = {
            //设置超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public CommonResult timeout() {
//        int i = 1 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new CommonResult(0x10000L, " >>> 处理成功", null);
    }

    public CommonResult testFallback() {

        return new CommonResult(0x10001L, "服务提供方超时无法使用", null);
    }

}
