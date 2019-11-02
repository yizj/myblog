package com.zjl.myblog.domain;

import com.zjl.myblog.utils.ConstantUtils;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotNull(message = ConstantUtils.USERNAMENOTNULL)
    @Size(min=6,max = 20,message = ConstantUtils.USERNAMESIZE)
    private String userName;

    @Column(name = "user_pwd")
    @Size(min=6,max = 20,message = ConstantUtils.PWD)
    private String userPwd;

    @Column(name="user_email")
    @Email(message =ConstantUtils.EMAILPATTERN )
    @NotNull(message = ConstantUtils.EMAILNOTNULL)
    private String userEmail;

    @Column(name="user_phone")
    @NotNull(message =ConstantUtils.PHONENOTNULL )
    @Pattern(regexp = "^[1][3-9][0-9]{9}$",message =ConstantUtils.PHONEPATTERN )
    private String userPhone;

}
