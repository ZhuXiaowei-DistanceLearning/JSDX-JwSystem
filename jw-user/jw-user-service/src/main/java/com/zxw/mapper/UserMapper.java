package com.zxw.mapper;

import com.zxw.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, String> {
}