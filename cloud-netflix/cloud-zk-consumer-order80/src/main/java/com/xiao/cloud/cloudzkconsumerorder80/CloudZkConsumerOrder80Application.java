package com.xiao.cloud.cloudzkconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CloudZkConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZkConsumerOrder80Application.class, args);
    }

}
