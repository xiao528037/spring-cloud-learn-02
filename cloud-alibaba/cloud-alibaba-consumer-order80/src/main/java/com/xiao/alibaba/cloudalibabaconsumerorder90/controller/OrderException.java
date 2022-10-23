package com.xiao.alibaba.cloudalibabaconsumerorder90.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-16 19:14:06
 * @description
 */
@RestControllerAdvice
public class OrderException {

    private LongAdder longAdder = new LongAdder();

    @ExceptionHandler(SocketTimeoutException.class)
    public CommonResult exception(SocketTimeoutException e) {
        longAdder.increment();
        return new CommonResult(longAdder.longValue(), "请求超时", null);
    }
}
