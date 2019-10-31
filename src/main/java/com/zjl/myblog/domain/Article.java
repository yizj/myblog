package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 文章实体类
@data 2019/10/30
*/
@Entity
@Table(name = "tb_article")
@Data
@ToString
public class Article implements Serializable {
    private static final long serialVersionUID = -3673908236045108562L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "article_typeid")
    private Integer articleTypeId;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name="article_content")
    private String articleContent;

    @Column(name="article_sendtime")
    private String articleSendTime;

    @Column(name="article_authid")
    private Integer articleAuthId;

    //文章阅读数
    @Column(name="article_count")
    private Integer articleCount;

    //文章来源
    @Column(name="article_from")
    private String articleFrom;

    @Column(name="article_info")
    private String articleInfo;

}
