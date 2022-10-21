package com.xiao.cloud.cloudconfigcenter3355;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient

public class CloudConfigCenter3355Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3355Application.class, args);
    }

}
