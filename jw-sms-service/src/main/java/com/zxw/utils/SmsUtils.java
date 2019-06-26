package com.zxw.utils;

import com.zxw.config.SmsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsUtils {

    @Autowired
    private SmsProperties prop;

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final Logger logger = LoggerFactory.getLogger(SmsUtils.class);

    public String sendSms(String phone, String code, String signName, String template) {
        System.out.println("------------");
        System.out.println("----****----");
        System.out.println("开始发送手机短信");
        System.out.println("------------");
        System.out.println("[手机号码]:"+phone);
        System.out.println("[验证码]:"+code);
        System.out.println("[签名]:"+signName);
        System.out.println("[模板号]:"+template);
        return "ok";
    }
}