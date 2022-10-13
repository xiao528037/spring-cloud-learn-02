package com.xiao.cloud.cloudconsumeroder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CloudConsumerOder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOder80Application.class, args);
    }

}
