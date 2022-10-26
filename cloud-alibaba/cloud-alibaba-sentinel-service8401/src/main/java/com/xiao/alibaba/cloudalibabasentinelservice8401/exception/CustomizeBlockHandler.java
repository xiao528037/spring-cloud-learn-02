package com.xiao.alibaba.cloudalibabasentinelservice8401.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiao.cloud.cloudcommon.common.CommonResult;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-25 21:24:33
 * @description 热点异常返回类
 */
public class CustomizeBlockHandler {

    public static CommonResult handlerMethod(String p1, String p2, BlockException blockException) {
        return new CommonResult(0x10000L, "热点key设置成功", "hotkey");
    }

    public static CommonResult fallbackMethod(String p1, String p2) {
        return new CommonResult(0x10000L, "fallback处理成功", "fallback");
    }
}
