package com.xiao.alibaba.cloudalibabasentinelservice8401.controller;

import com.xiao.alibaba.cloudalibabasentinelservice8401.service.ConsumerService;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-24 20:43:13
 * @description
 */

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class FlowLimitController {


    public final ConsumerService service;

    public FlowLimitController(ConsumerService consumerService) {
        this.service = consumerService;
    }

    @GetMapping("/get/{id}")
    public CommonResult getA(@PathVariable("id") Long id) {
        log.info("{} ", ">>>>>> 请求");
        return service.getPaymentById(id);
    }

    @GetMapping("/getTimeout")
    public CommonResult getB() throws InterruptedException {
        return service.getTimeout();
    }

    @GetMapping("/exception")
    public CommonResult exception() {
        return service.exception();
    }
}
