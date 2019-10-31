package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
@author zjl
@description 留言类
@data 2019/10/30
*/
@Entity
@Table(name = "tb_word")
@Data
@ToString
public class Word implements Serializable {
    private static final long serialVersionUID = -4691455148481647443L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "word_title")
    private String wordTitle;

    @Column(name = "word_content")
    private String wordContent;

    @Column(name="word_sendtime")
    private String wordSendTime;

    @Column(name="word_masterid")
    private Integer wordMasterId;

    @Column(name="word_authid")
    private Integer wordAuthid;
}
