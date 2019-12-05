package com.zjl.myblog.jmsconsumer.dto;

import lombok.Data;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/5
 * @date: 2019/12/5
 * @function: TODO
 */
@Data
public class EmailJmsDto {

    private String from;

    private String to;

    private String subject;

    private String content;

    private String rscPath;

    private String rscId;
}
