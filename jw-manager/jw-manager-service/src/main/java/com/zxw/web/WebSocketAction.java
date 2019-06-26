package com.zxw.web;

import org.springframework.web.bind.annotation.PathVariable;

//@RestController
//@RequestMappingpin("/websocket")
public class WebSocketAction {
//    @GetMapping("/{username}")
    public String sendMessage(@PathVariable("username") String username){
        System.out.println("-------------");
        System.out.println("----*****----");
        System.out.println("-------------");
        System.out.println("连接成功");
        return "";
    }
}
