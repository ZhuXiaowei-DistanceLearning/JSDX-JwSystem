package com.zxw.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String qx;

    public UserInfo() {
    }

}