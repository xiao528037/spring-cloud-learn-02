package com.xiao.alibaba.cloudalibabasentinelservice8401.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
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
public class FlowLimitController {

    @GetMapping("/testA")
    public CommonResult<String> getA() {
        return new CommonResult<>(0x10000L, "获取成功", "getA");
    }

    @GetMapping("/testB")
    public CommonResult<String> getB() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new CommonResult<>(0x10000L, "获取成功", "getB");
    }
}
