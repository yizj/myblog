package com.zjl.myblog.service.impl;

import com.zjl.myblog.constant.DateConsts;
import com.zjl.myblog.constant.RepositoryConsts;
import com.zjl.myblog.constant.ServiceConsts;
import com.zjl.myblog.constant.ViewConsts;
import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.dto.ArticleDto;
import com.zjl.myblog.dto.UserDto;
import com.zjl.myblog.repository.ArticleRepository;
import com.zjl.myblog.service.ArticleService;
import com.zjl.myblog.service.RedisService;
import com.zjl.myblog.util.CookieUtil;
import com.zjl.myblog.util.DateFormatUtil;
import com.zjl.myblog.util.JsonClassConvertUtil;
import com.zjl.myblog.util.RedisUtil;
import com.zjl.myblog.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private transient ArticleRepository articleRepository;

    @Autowired
    private transient RedisService redisService;

    @Override
    public ArticleDO addArticle(ArticleDO article, HttpServletRequest request) throws Exception {
        String resToken="";
        UserDto userDto=null;
        article.setArticleSendTime ( DateFormatUtil.getCurrentTime ( DateConsts.Y_M_D_HMS ) );
        String token=CookieUtil.getCookie ( request,ViewConsts.TOKEN );
        if(StringUtils.isEmpty ( token )){
            resToken=CookieUtil.getCookie ( request );
        }
        else {
             userDto=JsonClassConvertUtil.stringToBean ( redisService.get ( token ),UserDto.class );
        }
        if (userDto != null) {
            article.setArticleAuthId ( userDto.getId () );
            article.setArticleFrom ( userDto.getUserName () );
        }
        else {
            article.setArticleAuthId(0);
            article.setArticleFrom(resToken);
        }

        // 文章发布初，数量为0
        article.setArticleCount ( 0 );
        ArticleDO resArticle = articleRepository.save(article);

        if (resArticle == null) {
            throw new Exception("发布文章失败!");
        }

        // redis设置文章阅读数量
        String key=RedisUtil.getKey ( Arrays.asList ( ServiceConsts.ARTICLE_OBJECT_TYPE,
                resArticle.getId ().toString () ,
                ServiceConsts.ARTICLE_OBJECT_PROPERTY));
        redisService.set ( key,resArticle.getArticleCount ().toString () );
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
                if(!StringUtils.isEmpty ( articleDto.getArticleSendTime() )){
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

    @Transactional
    @Override
    public ArticleDO getArticleById(Integer id) {
        ArticleDO articleDO=articleRepository.findArticleDOById ( id );
        articleDO.setArticleCount (articleDO.getArticleCount ()+1);
        ArticleDO res=articleRepository.save ( articleDO );
        if (articleDO != null) {
            //更新redis
            String key=RedisUtil.getKey ( Arrays.asList ( ServiceConsts.ARTICLE_OBJECT_TYPE,
                    id.toString () ,
                    ServiceConsts.ARTICLE_OBJECT_PROPERTY));
            redisService.increment ( key,1 );
        }
        return res;
    }
}
