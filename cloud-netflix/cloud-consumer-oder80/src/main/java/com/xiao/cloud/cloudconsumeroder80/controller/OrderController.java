package com.xiao.cloud.cloudconsumeroder80.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 23:50:11
 * @description
 */
@RestController
@RequestMapping("/consumer/order")
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";
    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id) {
        log.info("1111");
        return restTemplate.getForObject(PAYMENT_URL + "/provider/payment/get/" + id, CommonResult.class);
    }

    @PostMapping("/add")
    public CommonResult<Payment> addPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/provider/payment/add", payment, CommonResult.class);
    }
}
