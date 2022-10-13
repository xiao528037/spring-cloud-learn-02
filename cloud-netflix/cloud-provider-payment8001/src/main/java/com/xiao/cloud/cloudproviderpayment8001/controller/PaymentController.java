package com.xiao.cloud.cloudproviderpayment8001.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import com.xiao.cloud.cloudproviderpayment8001.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:35:58
 * @description
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws CloudException {
        Payment payment = paymentService.selectById(id);
        return new CommonResult(0x10000L, "处理成功", payment);
    }

    @PostMapping("/add")
    public CommonResult addPayment( Payment payment) {
        payment = paymentService.addPayment(payment);

        return new CommonResult(0x10000L, "处理成功", payment);
    }
}
