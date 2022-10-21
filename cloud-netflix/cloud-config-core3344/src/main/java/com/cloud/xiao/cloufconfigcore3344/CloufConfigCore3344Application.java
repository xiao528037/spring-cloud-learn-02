package com.cloud.xiao.cloufconfigcore3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloufConfigCore3344Application {

    public static void main(String[] args) {
        SpringApplication.run(CloufConfigCore3344Application.class, args);
    }

}
