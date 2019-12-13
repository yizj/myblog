package com.zjl.myblog.service;

import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.dto.ArticleDto;
import com.zjl.myblog.vo.PageVO;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;


public interface ArticleService {

     ArticleDO addArticle(ArticleDO article, HttpServletRequest request) throws Exception;

     Page<ArticleDO> listArticles(PageVO pageVO);

     Page listArticlesByCondition(PageVO pageVO, ArticleDto articleDto);

     ArticleDO getArticleById(Integer id);
}
