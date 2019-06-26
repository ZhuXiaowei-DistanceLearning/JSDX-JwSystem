package com.zxw.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * 
 */
@Controller
@Scope("prototype")
public class UserAction {

    public String editPassword() throws IOException {
    	return null;
    }

    public String pageQuery() throws IOException {
    	return null;
    }

    private String[] roleIds;

    /**
     * 添加用户
     */
    public String add() {
    	return null;
    }


    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }
}
