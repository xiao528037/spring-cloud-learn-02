package com.xiao.cloud.cloudstreamrabbitprovider8801.service;

/**
 * @author aloneMan
 * @projectName spring-cloud-learn-02
 * @createTime 2022-10-22 20:01:21
 * @description
 */

public interface IMessageProvider {
    /**
     * 广播消息
     *
     * @param message
     */
    public void sendBroadcast(String message);

    /**
     * 分组发送消息
     * @param message 消息
     */
    public void sendGroup(String message);

}
