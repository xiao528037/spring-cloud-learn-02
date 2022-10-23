package com.xiao.alibaba.cloudalibabaconsumerorder90.service;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-16 18:43:46
 * @description
 */
@Service
@FeignClient(name = "nacos-provider")
public interface PaymentService {

    @GetMapping("/provider/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/provider/payment/getTimeout")
    void getTimeout();

    @PostMapping("/provider/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment);
}
