package com.xiao.alibaba.cloud.cloudalibabaproviderpayment9001.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSONObject;
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
        if (e instanceof FlowException) {
            json.put("code", -1);
            json.put("message", port + "接口限流");
        } else if (e instanceof DegradeException) {
            json.put("code", -2);
            json.put("message", port + "接口降级");
        } else if (e instanceof ParamFlowException) {
            json.put("code", -3);
            json.put("message", port + "参数限流");
        } else if (e instanceof AuthorityException) {
            json.put("code", -4);
            json.put("message", port + "授权异常");
        } else if (e instanceof SystemBlockException) {
            json.put("code", -5);
            json.put("message", port + "系统负载异常");
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(json.toJSONString());
    }
}
