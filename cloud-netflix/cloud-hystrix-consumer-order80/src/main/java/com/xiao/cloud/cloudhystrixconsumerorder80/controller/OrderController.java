package com.xiao.cloud.cloudhystrixconsumerorder80.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudhystrixconsumerorder80.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 23:50:11
 * @description
 */

@Slf4j
@RestController
@RequestMapping("/hystrix/consumer/order")
@DefaultProperties(defaultFallback = "testFallback")
public class OrderController {


    private final PaymentService paymentService;

    public OrderController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add")
    public CommonResult<Payment> addPayment(Payment payment) {
        return paymentService.addPayment(payment);
    }

    @GetMapping("/getTimeout")
    @HystrixCommand(commandProperties = {
            //设置超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public CommonResult getTimeout() {
        return paymentService.getTimeout();
    }


    @GetMapping("/exception")
    @HystrixCommand(fallbackMethod = "exceptionFallback",commandProperties = {
            //设置超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public CommonResult exception() {
        int i = 1 / 0;
        return new CommonResult(0x10000L, "处理成功", null);
    }

    public CommonResult exceptionFallback() {
        return new CommonResult(0x10002L, "客户端出现了异常 ", null);
    }


    public CommonResult testFallback() {
        return new CommonResult(0x10001L, "consumer <<< 客户端 <<<<< 超时无法使用", null);
    }
}
