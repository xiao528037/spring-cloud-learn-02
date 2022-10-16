package com.xiao.cloud.cloudconsulproviderpayment8007.controller;

import com.xiao.cloud.cloudcommon.common.CommonResult;
import com.xiao.cloud.cloudcommon.exception.CloudException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 21:53:26
 * @description
 */

@RestControllerAdvice
public class CloudExceptionHandler {

    @ExceptionHandler(CloudException.class)
    public CommonResult resultCodeCommonResult(CloudException e) {
        return new CommonResult(e.getResultCode());
    }
}
