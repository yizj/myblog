package com.zjl.myblog.domain;

import com.zjl.myblog.constant.ErrorConsts;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
@author zjl
@description 角色实体类
@data 2019/10/30
*/
@Entity
@Data
@Table(name="tb_role")
public class RoleDO implements Serializable {
    private static final long serialVersionUID = 8917044066759914275L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    @NotNull(message = ErrorConsts.ROLE_PATTERN)
    private String roleName;

    @ManyToMany(mappedBy="roleDOS")
    private Set<UserDO> userDOS=new HashSet<>();

    @ManyToMany(targetEntity = ActionDO.class,cascade = CascadeType.ALL)
    @JoinTable(name="tb_role_action",
            joinColumns={@JoinColumn(name="role_id",referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="action_id",referencedColumnName = "id")})
    private Set<ActionDO> actionDOS=new HashSet<>();

}
