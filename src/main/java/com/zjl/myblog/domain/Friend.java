package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 好友实体类
@data 2019/10/30
*/
@Entity
@Data
@Table(name = "tb_friend")
@ToString
public class Friend implements Serializable {
    private static final long serialVersionUID = 5591440628416674493L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //关注的朋友的id
    @Column(name = "friend_masterid")
    private Integer friendMasterId;

    //博主自己的ID
    @Column(name = "friend_id")
    private Integer friendId;

    @Column(name = "friend_memo_name")
    private String friendMemoName;

}
