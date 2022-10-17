package com.xiao.cloud.cloudhystrixproviderpayment8001.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import com.xiao.cloud.cloudhystrixproviderpayment8001.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:35:58
 * @description
 */
@RestController
@RequestMapping("/hystrix/provider/payment")
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
    public void getTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        log.info(">>>> {} ", "睡眠后执行了。");
    }
}
