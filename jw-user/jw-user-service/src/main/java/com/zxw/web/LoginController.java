package com.zxw.web;

import com.netflix.discovery.converters.Auto;
import com.zxw.pojo.Student;
import com.zxw.pojo.Teacher;
import com.zxw.pojo.User;
import com.zxw.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String test() {
        System.out.println("方法执行了");
        return "login";
    }

    @GetMapping("/query")
    @ResponseBody
    public Object login(@RequestParam(value = "username") String username, @RequestParam("password") String password, @RequestParam("RadioButtonList1") String RadioButtonList1) {
        if (RadioButtonList1.equals("学生")) {
            Teacher teacher = loginService.queryTeacher(username, password);
            return teacher;
        } else if (RadioButtonList1.equals("教师")) {
            Student student = loginService.queryStudent(username, password);
            return student;
        } else if (RadioButtonList1.equals("管理员")) {
            User user = loginService.queryUser(username, password);
            return user;
        }
        System.out.println("登录成功");
        return null;
    }

}
