package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 文章类型
@data 2019/10/30
*/

@Entity
@Table(name = "tb_articletype")
@Data
@ToString
public class ArticleType implements Serializable {
    private static final long serialVersionUID = -2459104959437545431L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "articletype_name")
    private String articleTypeName;

    @Column(name = "articletype_desc")
    private String articleTypeDesc;
}
