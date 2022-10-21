package com.xiao.cloud.cloudconfigcenter3355.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-21 21:32:46
 * @description
 */
@RestController
@RequestMapping("/configCenter/")
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/getinfo")
    public CommonResult getInfo() {
        return new CommonResult(0x10000L, "获取成功", info);
    }
}
