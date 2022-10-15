package com.xiao.cloud.cloudproviderpayment8004.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import com.xiao.cloud.cloudproviderpayment8004.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:35:58
 * @description
 */
@RestController
@RequestMapping("/zk_provider/payment")
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

    @PostMapping("/add")
    public CommonResult addPayment(@RequestBody Payment payment) {
        log.info(" add接口访问的是 >>> {} ", serverPort);
        payment = paymentService.addPayment(payment);
        return new CommonResult(0x10000L, serverPort + " >>> 处理成功", payment);
    }

    @GetMapping("/getDiscovery")
    public CommonResult getDiscovery() {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(service -> {
            log.info("element >>>  {} ", service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT-SERVICE");
        instances.stream().forEach(instance -> {
            log.info("{} \t {} \t {} \t {}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        });
        return new CommonResult(0x10000L, "处理成功", discoveryClient);
    }
}
