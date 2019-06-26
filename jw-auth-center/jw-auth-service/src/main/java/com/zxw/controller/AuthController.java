package com.zxw.controller;

import com.zxw.auth.utils.JwtUtils;
import com.zxw.auth.entity.UserInfo;
import com.zxw.config.JwtProperties;
import com.zxw.service.AuthService;
import enums.ExceptionEnums;
import exception.JwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("accredit")
    public ResponseEntity<String> authentication(@RequestParam("username") String username, @RequestParam("password") String passwrod, @RequestParam("RadioButtonList1") String RadioButtonList1, HttpServletRequest request, HttpServletResponse response) {
        String token = authService.authenication(username, passwrod, RadioButtonList1);
        if (null == token) {
            //没有认证
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println(token);
        //controller得到token要把token回送到客户端
        CookieUtils.setCookie(request, response, jwtProperties.getCookieName(),
                token, jwtProperties.getCookieMaxAge(), null, true);
        return ResponseEntity.ok("200");
    }

    @GetMapping("verify")
    public ResponseEntity verifyUser(@CookieValue("LY_TOKEN") String token,HttpServletRequest request, HttpServletResponse response) {
        try {
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            JwtUtils.generateToken(userInfo,jwtProperties.getPrivateKey(),jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(),
                    token, jwtProperties.getCookieMaxAge(), null, true);
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
