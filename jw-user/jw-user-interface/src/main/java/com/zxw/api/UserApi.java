package com.zxw.api;

import com.zxw.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserApi {

    @GetMapping("/query")
    User queryUser(@RequestParam(value = "username") String username,@RequestParam("password") String password, @RequestParam("RadioButtonList1") String RadioButtonList1);
}
