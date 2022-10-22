package com.xiao.cloud.cloudstreamrabbitprovider8801.service.impl;


import com.xiao.cloud.cloudcommon.entity.Payment;
import com.xiao.cloud.cloudstreamrabbitprovider8801.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-22 20:02:26
 * @description
 */

@Service("iMessageProvider")
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    private final StreamBridge streamBridge;

    private AtomicLong count = new AtomicLong(0);

    public IMessageProviderImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public void sendBroadcast(String message) {
        String uuid = UUID.randomUUID().toString();
        Payment payment = new Payment();
        payment.setId(count.getAndIncrement());
        payment.setSerial(uuid);
        streamBridge.send("myBroadcast-out-0", payment);
        log.info("发送的消息是 {} ", uuid);
    }

    @Override
    public void sendGroup(String message) {
        String uuid = UUID.randomUUID().toString();
        Payment payment = new Payment();
        payment.setId(count.getAndIncrement());
        payment.setSerial(uuid);
        streamBridge.send("myGroup-out-0", payment);
        log.info("发送的消息是 {} ", uuid);
    }
}
