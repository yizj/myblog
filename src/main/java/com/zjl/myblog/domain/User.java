package com.zjl.myblog.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.zjl.myblog.utils.ConstantUtils;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zjl
 * @description 用户实体映射类
 * @data 2019/10/30
 */
@Entity
@Table(name = "tb_user")
@Data
@ToString(exclude = {"roles"})
public class User implements Serializable {

    private static final long serialVersionUID = -7629523597327671712L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    @NotNull(message = ConstantUtils.USERNAMENOTNULL)
    @Size(min = 6, max = 20, message = ConstantUtils.USERNAMESIZE)
    private String userName;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_email")
    @Email(message = ConstantUtils.EMAILPATTERN)
    @NotNull(message = ConstantUtils.EMAILNOTNULL)
    private String userEmail;

    @Column(name = "user_phone")
    @NotNull(message = ConstantUtils.PHONENOTNULL)
    @Pattern(regexp = "^[1][3-9][0-9]{9}$", message = ConstantUtils.PHONEPATTERN)
    private String userPhone;

    @JSONField(serialize = false)
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_user_role",
            //当前对象在中间表中的外键
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            //对方对象在中间表中的外键
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles = new HashSet<>();

}
