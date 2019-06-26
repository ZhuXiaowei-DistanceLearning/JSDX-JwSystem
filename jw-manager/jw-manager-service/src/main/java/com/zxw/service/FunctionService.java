package com.zxw.service;

import com.zxw.mapper.FunctionMapper;
import enums.ExceptionEnums;
import exception.JwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.AuthFunction;
import vo.LoginUser;

import java.util.List;

@Service
public class FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    public List<AuthFunction> findMenu(LoginUser loginUser) {
        List<AuthFunction> list = null;
        switch (loginUser.getQx()) {
            case "学生":
                list = functionMapper.findMenuByStudentid(loginUser.getId());
                return list;
            case "教师":
                list = functionMapper.findMenuByTeacherid(loginUser.getId());
                return list;
            case "管理员":
                list = functionMapper.findMenuByUserid(loginUser.getId());
                return list;
            default:
                throw new JwException(ExceptionEnums.NOT_FOUND_AUTH_FUNCTION);
        }
//        Subject subject = SecurityUtils.getSubject();
//        Object object = subject.getPrincipal();
//        List<AuthFunction> list = null;
//        if (object instanceof TUser) {
//            list = functionMapperCustom.findMenuByUserid(((TUser) object).getId());
//        } else if (object instanceof TTeacher) {
//            list = functionMapperCustom.findMenuByTeacherid(((TTeacher) object).getTid());
//        } else if (object instanceof TStudent) {
//            list = functionMapperCustom.findMenuByStudentid(((TStudent) object).getSid());
//        }
    }
}
