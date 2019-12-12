package com.zjl.myblog.service.impl;

import com.zjl.myblog.constant.RepositoryConsts;
import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.dto.ArticleDto;
import com.zjl.myblog.repository.ArticleRepository;
import com.zjl.myblog.service.ArticleService;
import com.zjl.myblog.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


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

    @Override
    public Page<ArticleDO> listArticles(PageVO pageVO){

        Pageable pageable=PageRequest.of ( pageVO.getPage ()-1,
                pageVO.getSize (),
                Sort.Direction.ASC,
                RepositoryConsts.ARTICLE_ORDERBY_CONDITION
        );
        return  articleRepository.findAll ( pageable );
    }

    @Override
    public Page<ArticleDO> listArticlesByCondition(PageVO pageVO, ArticleDto articleDto) {

        Pageable pageable=PageRequest.of ( pageVO.getPage ()-1,
                pageVO.getSize (),
                Sort.Direction.ASC,
                RepositoryConsts.ARTICLE_ORDERBY_CONDITION
        );
        Specification<ArticleDO> specification=new Specification<ArticleDO> ( ) {

            @Override
            public Predicate toPredicate(Root<ArticleDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates=new ArrayList<> ();
                if(!StringUtils.isEmpty ( articleDto.getCondition () )){
                    predicates.add (
                            criteriaBuilder.equal (
                                    root.get ( "articleSendTime" )
                                            .as(String.class),
                                    articleDto.getArticleSendTime ()
                            )
                    );
                }
                Predicate[] predicates1= new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicates1));
            }
        };

        return  articleRepository.findAll ( specification,pageable );
    }
}
