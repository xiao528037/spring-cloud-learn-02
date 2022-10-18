package com.xiao.cloud.cloudgateway7527.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-18 20:29:00
 * @description 通过编码的方式构建路由
 */
@Configuration
public class GatewayRouterConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();
        /* routes.route("payment_rout", r -> r.path("/provider/payment/**").uri("lb://PROVIDER-PAYMENT-SERVICE"));*/

        routes.route("predicates_route", r -> {
                    //表示该路径只能在2022年10月18日21点22分之前可以调用
                    ZonedDateTime zonedDateTime = ZonedDateTime.of(2022, 10, 18, 21, 22, 00, 0, ZoneId.of("Asia/Shanghai"));
                    return r.after(zonedDateTime).and().path("/provider/payment/get/**").uri("lb://PROVIDER-PAYMENT-SERVICE");
                }
        );
        return routes.build();
    }
}
