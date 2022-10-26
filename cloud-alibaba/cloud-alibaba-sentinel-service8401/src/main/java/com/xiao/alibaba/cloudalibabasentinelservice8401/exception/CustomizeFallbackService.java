package com.xiao.alibaba.cloudalibabasentinelservice8401.exception;

import com.xiao.alibaba.cloudalibabasentinelservice8401.service.ConsumerService;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-26 18:03:50
 * @description
 */
@Component
public class CustomizeFallbackService implements ConsumerService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult<>(0x10001L, "走了openfeign-fallback方法 ", id);
    }

    @Override
    public CommonResult getTimeout() {
        return new CommonResult<>(0x10001L, "走了openfeign-fallback方法 ", "getTimeout method");
    }

    @Override
    public CommonResult exception() {
        return new CommonResult<>(0x10001L, "走了openfeign-fallback方法 ", "exception method");
    }

    @Override
    public CommonResult sentinel(Long id) {
        return new CommonResult<>(0x10001L, "走了openfeign-fallback方法 ", "sentinel method");
    }
}
