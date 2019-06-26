package com.zxw.config;

import com.zxw.utils.SmsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {
    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private SmsUtils smsUtils;

    /**
     * - `@Componet`：类上的注解，注册到Spring容器
     * - `@RabbitListener`：方法上的注解，声明这个方法是一个消费者方法，需要指定下面的属性：
     * - `bindings`：指定绑定关系，可以有多个。值是`@QueueBinding`的数组。`@QueueBinding`包含下面属性：
     * - `value`：这个消费者关联的队列。值是`@Queue`，代表一个队列
     * - `exchange`：队列所绑定的交换机，值是`@Exchange`类型
     * - `key`：队列和交换机绑定的`RoutingKey`
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "jw.sms.queue", durable = "true"), exchange = @Exchange(value = "jw.sms.exchange", ignoreDeclarationExceptions = "true"), key = {"sms.verify.code"}))
    public void listenerSms(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String phone = map.get("phone");
        String code = map.get("code");
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(phone)) {
            // 放弃处理
            return;
        }
        // 发送消息
        String sms = smsUtils.sendSms(phone, code, smsProperties.getSignName(), smsProperties.getVerifyCodeTemplate());
        if (sms == null || sms.equals("")) {
            // 发送失败
            throw new RuntimeException();
        }
    }
}
