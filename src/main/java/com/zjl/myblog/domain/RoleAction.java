package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 角色权限映射类
@data 2019/10/30
*/
@Entity
@Data
@Table(name = "tb_role_action")
@ToString
public class RoleAction implements Serializable {
    private static final long serialVersionUID = 8498223194744423909L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //角色id
    @Column(name = "role_id")
    private Integer roleId;

    //权限ID
    @Column(name = "action_id")
    private Integer actionId;
}
