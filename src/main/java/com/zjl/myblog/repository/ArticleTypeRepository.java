package com.zjl.myblog.repository;

import com.zjl.myblog.domain.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleType,Integer> {
}
