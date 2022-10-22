package com.xiao.cloud.cloudstreamrabbitprovider8801.controller;

import com.xiao.cloud.cloudstreamrabbitprovider8801.service.IMessageProvider;
import com.xiao.cloud.cloudstreamrabbitprovider8801.service.impl.IMessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-22 20:32:33
 * @description
 */
@RequestMapping("/api/v1/mq")
@RestController
public class MessageController {

    private final IMessageProvider iMessageProvider;

    public MessageController(IMessageProvider iMessageProvider) {
        this.iMessageProvider = iMessageProvider;
    }

    @GetMapping("/broadcast/{message}")
    public void broadcast(@PathVariable("message") String message) {
        iMessageProvider.sendBroadcast(message);
    }

    @GetMapping("/group/{message}")
    public void group(@PathVariable("message") String message) {
        iMessageProvider.sendGroup(message);
    }
}
