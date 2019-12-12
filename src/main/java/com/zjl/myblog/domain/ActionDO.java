package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author zjl
 * @description 权限类
 * @data 2019/10/30
 */
@Entity
@Table(name = "tb_action")
@Data
@ToString(exclude = {"roleDOS"})
public class ActionDO implements Serializable {

    private static final long serialVersionUID = -4966720157938737838L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "actiob_url")
    private String actiobUrl;

    @Column(name = "actiob_group_id")
    private String actiobGroupId;

    @Column(name = "action_name")
    private String actionName;

    @ManyToMany(mappedBy = "actionDOS",fetch = FetchType.EAGER)
    private Set<RoleDO> roleDOS;
}
