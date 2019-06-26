package com.zxw.service;

import com.zxw.mapper.StudentMapper;
import com.zxw.mapper.Student_RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Student_Role;
import pojo.TStudent;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Student_RoleMapper mapper;

    @Transactional
    public void insertStudent(TStudent student) {
        studentMapper.insert(student);
    }

    @Transactional
    public void insertStudentRole(Student_Role student) {
        mapper.insert(student);
    }
}