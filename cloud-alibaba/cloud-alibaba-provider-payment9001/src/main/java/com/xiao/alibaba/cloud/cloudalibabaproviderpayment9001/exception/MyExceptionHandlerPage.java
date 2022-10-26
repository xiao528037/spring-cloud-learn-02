package com.xiao.alibaba.cloud.cloudalibabaproviderpayment9001.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiao.cloud.cloudcommon.common.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-24 21:28:18
 * @description
 */
@Component
public class MyExceptionHandlerPage implements BlockExceptionHandler {

    @Value("${server.port}")
    private String port;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        JSONObject json = new JSONObject();
        CommonResult commonResult = null;
        if (e instanceof FlowException) {
            commonResult = new CommonResult(0x10001L, port + "接口限流", null);
        } else if (e instanceof DegradeException) {
            commonResult = new CommonResult(0x10002L, port + "接口降级", null);
        } else if (e instanceof ParamFlowException) {
            commonResult = new CommonResult(0x10003L, port + "参数限流", null);
        } else if (e instanceof AuthorityException) {
            commonResult = new CommonResult(0x10003L, port + "授权异常", null);
        } else if (e instanceof SystemBlockException) {
            commonResult = new CommonResult(0x10003L, port + "系统负载异常", null);
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(commonResult));
    }
}
