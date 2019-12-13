package com.zjl.myblog.repository;

import com.zjl.myblog.domain.ArticleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleDO, Integer>,JpaSpecificationExecutor {

    ArticleDO findArticleDOById(Integer id);
}
