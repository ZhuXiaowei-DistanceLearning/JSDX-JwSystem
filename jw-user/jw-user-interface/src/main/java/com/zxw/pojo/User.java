package com.zxw.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private Double salary;

    private Date birthday;

    private String gender;

    private String station;

    private String telephone;

    private String remark;

    private String qx;
}
