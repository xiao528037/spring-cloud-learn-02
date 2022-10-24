package com.xiao.alibaba.cloudalibabasentinelservice8401.service;

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
@FeignClient(value = "nacos-provider")
public interface ConsumerService {

    @GetMapping("/provider/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/getTimeout")
    public CommonResult getTimeout();
}
