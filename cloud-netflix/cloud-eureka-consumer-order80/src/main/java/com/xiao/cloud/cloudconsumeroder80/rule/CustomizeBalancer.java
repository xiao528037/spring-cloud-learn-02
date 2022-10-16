package com.xiao.cloud.cloudconsumeroder80.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;


@Slf4j
public class CustomizeBalancer implements ReactorServiceInstanceLoadBalancer {
    private AtomicInteger count = new AtomicInteger(0);    // 被调用的次数
    //服务个数
    private Integer totalServer = 0;
    // 服务列表
    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;
    private final Mono<Response<ServiceInstance>> responseMono;

    public CustomizeBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
        this.responseMono = serviceInstanceListSupplierProvider.getIfAvailable().get().next().map(this::getInstanceResponse);
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        return responseMono;
    }


    //自定义轮询算法
    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances) {

        int now = count.getAndIncrement();
        log.info(" 第 >>> {} <<<请求 ", now);
        return new DefaultResponse(instances.get(now % instances.size()));
    }
}
