package com.zxw.service;

import com.zxw.auth.entity.UserInfo;
import com.zxw.client.UserClient;
import com.zxw.config.JwtProperties;
import com.zxw.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private UserClient userClient;

    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    public String authenication( String username, String passwrod,String RadioButtonList1) {
        try {
            User user = this.userClient.queryUser(username, passwrod,RadioButtonList1);
            if (user == null) {
                logger.error("用户验证失败！");
                return null;
            }
            UserInfo userInfo = new UserInfo();
            userInfo.setId(Long.parseLong(user.getId()));
            userInfo.setUsername(user.getUsername());
            userInfo.setQx(user.getQx());
            String token = com.zxw.auth.utils.JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
