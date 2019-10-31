package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 权限类
@data 2019/10/30
*/
@Entity
@Table(name = "tb_action")
@Data
@ToString
public class Action implements Serializable {
    private static final long serialVersionUID = -4966720157938737838L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "actiob_url")
    private String actiobUrl;

    //父级权限
    @Column(name = "actiob_group_id")
    private String actiobGroupId;

    //权限名称
    @Column(name="action_name")
    private String actionName;

}
