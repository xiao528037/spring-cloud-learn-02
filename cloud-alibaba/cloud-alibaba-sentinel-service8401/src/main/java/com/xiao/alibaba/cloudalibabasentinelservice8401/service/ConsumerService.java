package com.xiao.alibaba.cloudalibabasentinelservice8401.service;

import com.xiao.alibaba.cloudalibabasentinelservice8401.exception.CustomizeFallbackService;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-24 21:08:26
 * @description
 */

@Service
@FeignClient(value = "nacos-provider", fallback = CustomizeFallbackService.class)
public interface ConsumerService {

    @GetMapping("/provider/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/provider/payment/getTimeout")
    public CommonResult getTimeout();

    @GetMapping("/provider/payment/exception")
    public CommonResult exception();

    @GetMapping("/provider/payment/sentinel/{id}")
    public CommonResult sentinel(@PathVariable("id") Long id);
}
