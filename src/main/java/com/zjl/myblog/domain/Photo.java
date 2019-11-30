package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zjl
 * @description 照片
 * @data 2019/10/30
 */
@Entity
@ToString
@Table(name = "tb_photo")
@Data
public class Photo implements Serializable {
    private static final long serialVersionUID = 8493191393416980345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "photo_addr")
    private String photoAddr;

    @Column(name = "photo_send_time")
    private String photoSendTime;

    @Column(name = "photo_info")
    private String photoInfo;

    @Column(name = "master_id")
    private Integer masterId;

}
