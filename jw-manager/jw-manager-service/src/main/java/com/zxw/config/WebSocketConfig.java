package com.zxw.config;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter(){
//        return new ServerEndpointExporter();
//    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
            webSocketHandlerRegistry.addHandler(new WebSocketHandler(),"/websocket").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(new WebSocketHandler(),"/sock-js").addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*").withSockJS();
    }
}
