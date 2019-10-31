package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 用户权限映射类
@data 2019/10/30
*/
@Entity
@Table(name = "tb_user_role")
@Data
@ToString
public class UserRole implements Serializable {
    private static final long serialVersionUID = 3386219290613933767L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //角色id
    @Column(name = "role_id")
    private Integer roleId;

    //用户ID
    @Column(name = "user_id")
    private Integer userId;
}
