package com.james;

/**
 * Created by 何强
 * date 2017/4/17
 * description
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker//1
//@EnableWebSocketMessageBroker注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息，
// 这时候控制器（controller）开始支持@MessageMapping,就像是使用@requestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    //注册一个Stomp的节点（endpoint）,并指定使用SockJS协议
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS(); //2
    }

    //配置消息代理（MessageBroker）
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//3
    }
}
