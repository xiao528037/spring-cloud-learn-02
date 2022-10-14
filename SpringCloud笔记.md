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

## 遇到的问题
> 1. 统一返回时，出现空JSON，没有设置GET/SET方法导致
> 2. 