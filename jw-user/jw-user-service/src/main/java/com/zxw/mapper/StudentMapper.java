package com.zxw.mapper;

import com.zxw.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMapper extends JpaRepository<Student, String> {
}
