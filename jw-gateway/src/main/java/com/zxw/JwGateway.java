package com.zxw;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class JwGateway {
    public static void main(String[] args) {
        SpringApplication.run(JwGateway.class);
    }
}

