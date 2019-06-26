package com.zxw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigure {
    @Bean
    public MyEndpointConfigure configure(){
        return  new MyEndpointConfigure();
    }
}
