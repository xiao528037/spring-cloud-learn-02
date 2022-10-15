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
# Eureka
![eureka.pn](image/eureka.png)
- 使用Eureka Client链接到Eureka Server上并保持心跳 
- 服务消费这通过Eureka Server获取注册的服务信息,然后通过相关信息,然后进行远程调用
- Eureka Server 集群部署保证高可用行
## Eureka Server
EurekaServer中的服务注册表中将会存储所有可用服务节点的信息。
## Eureka Client
- 内置负载均衡,使用轮询的方式进行服务调用
- 启动后默认每三十秒向Eureka Server发送心跳，如果Eureka Server在多个周期中没有收到心跳，则表示该服务离线，并将其移除，默认时间是90秒






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