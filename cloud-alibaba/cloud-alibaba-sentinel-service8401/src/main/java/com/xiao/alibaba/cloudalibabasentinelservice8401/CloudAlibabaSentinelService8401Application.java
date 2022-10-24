package com.xiao.alibaba.cloudalibabasentinelservice8401;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaSentinelService8401Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelService8401Application.class, args);
    }

}
