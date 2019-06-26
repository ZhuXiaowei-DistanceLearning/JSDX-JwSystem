package com.zxw.service;

import com.zxw.mapper.UserMapper;
import com.zxw.pojo.Student;
import com.zxw.pojo.Teacher;
import com.zxw.pojo.User;
import enums.ExceptionEnums;
import exception.JwException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import utils.NumberUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    static final String KEY_PREFIX = "user:code:phone:";

    static final String phone = "15807448980";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public User queryUser(String username, String password) {
        sendVerifyCode(phone);
        String code = redisTemplate.opsForValue().get(KEY_PREFIX + phone);
        System.out.println("[获取到验证码:"+code+"]");
        User user = new User();
        user.setId(username);
        user.setPassword(password);
        Example<User> example = Example.of(user);
        Optional<User> optional = userMapper.findOne(example);
        if (!optional.isPresent()) {
            throw new JwException(ExceptionEnums.ID_OR_PASSWORD_NOT_FOUND);
        }
        return optional.get();
    }

    public Teacher queryTeacher(String username, String password) {

        return null;
    }

    public Student queryStudent(String username, String password) {
        return null;
    }

    public Boolean sendVerifyCode(String phone) {
        String code = NumberUtils.generateCode(6);
        try {
            Map<String, String> msg = new HashMap<>();
            msg.put("phone", phone);
            msg.put("code", code);
            amqpTemplate.convertAndSend("jw.sms.exchange", "sms.verify.code", msg);
            redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
