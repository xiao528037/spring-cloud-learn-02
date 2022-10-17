# SpringCloud笔记

1. 服务注册中心
    - <font color='red'>Eureka 停止维护</font>
    - Zookeeper 可用
    - Consul 可用
    - <font color='green'>Nacos 推荐</font>

2. 服务调用
    - Ribbon 可用
    - LoadBalancer 可用
    - <font color='red'>Feign 停止维护</font>
    - <font color='GREEN'>OpenFeign 推荐</font>

3. 服务降级
    - <font color='red'>Hystrix 停止维护</font>
    - resilience4j(国外使用)
    - <font color='green'>sentinel 推荐</font>
4. 服务网关
    - <font color='red'>Zuul 停止维护</font>
    - <font color='PINK'>Zuul2 不推荐</font>
    - <font color='green'>getaway 推荐</font>
5. 服务配置
    - <font color='red'>Config 停止维护</font>
    - <font color='green'>Nacos</font>
6. 服务总线
    - <font color='pink'>Bus不推荐</font>
    - <font color='green'>Nacos</font>

# Eureka注册中心

![eureka.pn](image/eureka.png)

- 使用Eureka Client链接到Eureka Server上并保持心跳
- 服务消费这通过Eureka Server获取注册的服务信息,然后通过相关信息,然后进行远程调用
- Eureka Server 集群部署保证高可用行

## Eureka Server

EurekaServer中的服务注册表中将会存储所有可用服务节点的信息。

## Eureka Client

- 内置负载均衡,使用轮询的方式进行服务调用
- 启动后默认每三十秒向Eureka Server发送心跳，如果Eureka Server在多个周期中没有收到心跳，则表示该服务离线，并将其移除，默认时间是90秒

## Eureka Cluster（集群）

- 多个Eureka Server相互注册组建一个集群，对外暴露一个服务注册接口
- 实现负载均衡
- 实现故障容错，保证某些注册中心宕机的情况下，服务仍然可以调用。

## 服务集群 CAP

Eureka属于 AP，一致性和分区容错性

## Eureka保护机制

- 一定时间内Eureka Server没有接收到某个微服务的心跳，Eureka Server将会注销实例（默认是90秒）
- 当某个服务正常，但是网络发生故障（导致延时、卡顿、拥挤）时，这个实例无法和Eureka Server正常通信，则会进入"自我保护机制"

## Zookeeper注册中心

1. 配置好zookeeper，启动

2. 创建相关的SpringBoot服务，导入对应的包

3. 配置YAML文件

    1. ```yaml
        server:
        port: 80
        spring:
        application:
          name: cloud-zk-consumer-order
        cloud:
          zookeeper:
            # 注册中心地址
            connect-string: 127.0.0.1:2181
            # 会话超时时间
            session-timeout: 5000
            # 链接超时时间
            connection-timeout: 5000
            # 最大重试次数
            max-retries: 5
      ```

4. 启动服务即可

## Consul注册中心

1. 下载consul服务端，并启动

    1. ```sh
        consul agent -dev
      ```

2. 创建springboot服务导入对应的consul client包

3. 配置YAML文件

   ```yaml
   server:
     port: 80
   
   spring:
     application:
       name: consul-consumer-order
     cloud:
       consul:
         host: 127.0.0.1
         port: 8500
         discovery:
           #是否注册
           register: true
           #健康检查路径
           health-check-path: /actuator/health
           #健康检查时间间隔
           health-check-interval: 15s
           #开启IP地址注册
           prefer-ip-address: true
   
   ```

# 负载均衡

spring-cloud-netflix会默认自动轮询的负载均衡

## Ribbon
ribbon在cloud-netflix-2021版本中已经弃用，导入后不能够正确的找到服务，无法使用
- RoundRibbonRule 线性轮询策略
- RetryRule 重试策略
- WeightedResponseTimeRule 加权响应时间策略
- RandomRule 随机策略
- ClientConfigEnabledRoundRobbinRule 客户端配置启动线性轮询策略
- BestAvailableRule 最空闲策略
- PredicateBasedRule 过滤线性轮询策略
- ZoneAvoidanceRule 区域感知论序策略
- AvailabilityFilteringRule 可用性过滤策略
## loadBalancer

### 负载模式
- RandomLoadBalancer 随机策略
- RoundRobinLoadBalancer 轮询策略

LoadBalancer只提供了两种负载策略，其他的由开发这通过实现ReactorServiceInstanceLoadBalancer接口在定义负载规则

### 配置问题
```java
@LoadBalancerClient(name = "PROVIDER-PAYMENT-SERVICE", configuration = CustomRandomLoadBalancer.class)
```
> name是服务提供者在注册中心的统一名字，configuration指定负载规则

# HyStrix

## 服务降级

> 当服务出现以下情况后，返回友好提示，保证调用方不会长时间的等待或者抛出异常。

- 服务降级一般放在客户端

需要降级处理的情况：

- 程序运行异常
- 请求超时
- 服务熔断出发服务降级
- 线程池/信号量打满也会导致服务降级

## 服务熔断

> 服务达到最大访问后，拒绝请求，并返回友好提示。防止突然大量的并发请求导致服务奔溃
>
> 属于兜底策略，服务降级->服务熔断->恢复调用链路

## 服务限流

> 按照指定的规则进行请求处理，比如：每秒只能处理多少个请求





# 遇到的问题

## 1. 统一返回时，出现空JSON，没有设置GET/SET方法导致

## 2. JRebel不自动加载的问题

![img.png](image/img.png)

## 3. 关于maven编译时总是切换编译的JDK版本的问题,在maven中添加编译版本和编译后目标版本即可解决

```xml

<profile>
    <id>JDK1.8</id>
    <activation>
        <activeByDefault>true</activeByDefault>
    </activation>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <encoding>UTF-8</encoding>
    </properties>
</profile>
```

## 关于Mac配置hosts域名代理后，通过域名无法访问的问题

![img.png](image/hosts.png)

导致原因：开启了系统代理（比如VPN）

![img.png](image/clashx.png)

解决办法：在网络偏好设置中放行此域名

![img.png](image/network-config.png)