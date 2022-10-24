package com.xiao.alibaba.cloudalibabaconfigclient3377.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-23 20:05:03
 * @description
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/get")
    public CommonResult<String> getInfo() {
        return new CommonResult<>(0x10000L, "success", info);
    }
}
