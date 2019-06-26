package com.zxw.mapper;

import com.zxw.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherMapper extends JpaRepository<Teacher, String> {
}
