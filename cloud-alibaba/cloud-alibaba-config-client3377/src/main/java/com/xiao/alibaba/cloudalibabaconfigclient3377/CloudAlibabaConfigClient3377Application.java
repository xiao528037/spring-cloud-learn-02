package com.xiao.alibaba.cloudalibabaconfigclient3377;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CloudAlibabaConfigClient3377Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigClient3377Application.class, args);
    }

}
