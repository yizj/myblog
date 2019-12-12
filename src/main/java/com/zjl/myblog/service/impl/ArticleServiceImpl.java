package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.repository.ArticleRepository;
import com.zjl.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleDO addArticle(ArticleDO article) throws Exception {
        ArticleDO resArticle = articleRepository.save(article);
        if (resArticle == null) {
            throw new Exception("发布文章失败!");
        }
        return resArticle;
    }
}
