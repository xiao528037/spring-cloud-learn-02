package com.xiao.cloud.cloudeurekaopenfeignconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
public class CloudEurekaOpenfeignConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaOpenfeignConsumerOrder80Application.class, args);
    }

}
