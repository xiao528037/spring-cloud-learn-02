package com.xiao.cloud.cloudstreamrabbitconsumer8802.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-22 21:33:38
 * @description
 */

@Component
@Slf4j
public class MessageConsumer {

    @Bean
    public Consumer<String> myBroadcast() {
        return message -> log.info("接收到的广播信息是 >>> {} ", JSON.parseObject(message));
    }

    @Bean
    public Consumer<String> myGroup() {
        return message -> log.info("接收到的分组信息是 >>> {} ", message);
    }
}
