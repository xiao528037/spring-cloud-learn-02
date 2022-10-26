package com.xiao.alibaba.cloud.cloudalibabaproviderpayment9001.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiao.alibaba.cloud.cloudalibabaproviderpayment9001.service.PaymentService;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:35:58
 * @description
 */
@RestController
@RequestMapping("/provider/payment")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    private final DiscoveryClient discoveryClient;

    public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws CloudException {
        log.info(" get接口访问的是 >>> {} ", serverPort);
        Payment payment = paymentService.selectById(id);
        return new CommonResult(0x10000L, serverPort + " >>> 处理成功", payment);
    }


    @GetMapping("/getTimeout")
    public CommonResult getTimeout() {
        return paymentService.timeout();
    }

    @GetMapping("/exception")
    public CommonResult exception() {
        return paymentService.exception();
    }

    @GetMapping("/circuit_breaker/{id}")
    public CommonResult circuitBreaker(@PathVariable("id") Long id) throws CloudException {
        return paymentService.circuitBreaker(id);
    }

    @GetMapping("/sentinel/{id}")
    @SentinelResource(value = "TEST_SENTINEL", blockHandler = "sentinel")
    public CommonResult testSentinel(@PathVariable("id") Long id) throws CloudException {
        Payment payment = paymentService.selectById(id);
        return new CommonResult(0x10000L, serverPort + " >>> 处理成功", payment);
    }

    public CommonResult sentinel(Long id, BlockException exception) {
        return new CommonResult(0x10001L, "接口被限流辣～", "限流了");
    }
}
