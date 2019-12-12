package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.ArticleTypeDO;
import com.zjl.myblog.repository.ArticleTypeRepository;
import com.zjl.myblog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public ArticleTypeDO addArticleType(ArticleTypeDO articleType) throws Exception {
        ArticleTypeDO articleType1 = articleTypeRepository.save(articleType);
        if (articleType == null) {
            throw new Exception("添加文章种类出错");
        }
        return articleType1;
    }
}
