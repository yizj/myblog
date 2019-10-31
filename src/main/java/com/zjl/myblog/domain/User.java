package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 用户实体映射类
@data 2019/10/30
*/
@Entity
@Table(name = "tb_user")
@Data
@ToString
public class User implements Serializable{

    private static final long serialVersionUID = -7629523597327671712L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_phone")
    private String userPhone;

}
