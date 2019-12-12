package com.zjl.myblog.dto;

import com.zjl.myblog.domain.ArticleDO;
import lombok.Data;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/12
 * @date: 2019/12/12
 * @function: TODO
 */
@Data
public class ArticleDto extends ArticleDO {

    private String condition;
}
