package com.zxw.web;

import com.zxw.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vo.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/function")
public class FunctionAction {

    @Autowired
    private FunctionService functionService;

    @PostMapping("/findMenu")
    public ResponseEntity<List> findMenu(@RequestBody LoginUser loginUser, HttpServletRequest request, HttpServletResponse response){
        return ResponseEntity.ok(functionService.findMenu(loginUser));
    }
}
