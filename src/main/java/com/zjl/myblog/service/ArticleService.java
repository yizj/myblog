package com.zjl.myblog.service;

import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.dto.ArticleDto;
import com.zjl.myblog.vo.PageVO;
import org.springframework.data.domain.Page;



public interface ArticleService {

     ArticleDO addArticle(ArticleDO article) throws Exception;

     Page<ArticleDO> listArticles(PageVO pageVO);

     Page listArticlesByCondition(PageVO pageVO, ArticleDto articleDto);
}
