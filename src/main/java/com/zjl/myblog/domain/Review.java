package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 评论实体类
@data 2019/10/30
*/
@Entity
@Data
@Table(name = "tb_review")
@ToString
public class Review implements Serializable {
    private static final long serialVersionUID = -6888169019765149804L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //被评论文章的ID
    @Column(name = "article_id")
    private Integer articleId;

    //评论人的ID
    @Column(name = "master_id")
    private Integer masterId;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "review_time")
    private String reviewTime;

    @Column(name = "auth_id")
    private Integer authId;

}
