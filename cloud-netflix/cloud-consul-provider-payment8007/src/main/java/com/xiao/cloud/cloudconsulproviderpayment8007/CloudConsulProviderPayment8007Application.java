package com.xiao.cloud.cloudconsulproviderpayment8007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulProviderPayment8007Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulProviderPayment8007Application.class, args);
    }

}
