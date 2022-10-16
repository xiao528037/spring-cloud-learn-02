package com.xiao.cloud.cloudconsumeroder80.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-13 23:51:08
 * @description
 */
@Configuration
@LoadBalancerClient(name = "PROVIDER-PAYMENT-SERVICE", configuration = CustomRandomLoadBalancer.class)
public class ApplicationContextConfig {

    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
