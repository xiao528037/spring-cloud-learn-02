package com.xiao.cloud.cloudconsulconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class CloudConsulConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulConsumerOrder80Application.class, args);
    }

}
