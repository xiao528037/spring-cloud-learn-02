package com.xiao.cloud.cloudstreamrabbitconsumer8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.function.Consumer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class CloudStreamRabbitConsumer8802Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitConsumer8802Application.class, args);
    }



}
