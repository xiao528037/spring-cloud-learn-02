package com.xiao.cloud.cloudgateway7527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGateway7527Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway7527Application.class, args);
    }

}
