package com.xiao.cloud.cloudproviderpayment8004.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiao.cloud.cloudcommon.common.ResultCode;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;

import com.xiao.cloud.cloudproviderpayment8004.mapper.PaymentMapper;
import com.xiao.cloud.cloudproviderpayment8004.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:21:01
 * @description
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;

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
}
