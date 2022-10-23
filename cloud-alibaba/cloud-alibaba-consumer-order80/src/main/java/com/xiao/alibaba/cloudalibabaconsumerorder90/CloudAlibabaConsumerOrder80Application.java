package com.xiao.alibaba.cloudalibabaconsumerorder90;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerOrder80Application.class, args);
    }

}
