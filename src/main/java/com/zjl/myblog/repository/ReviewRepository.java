package com.zjl.myblog.repository;

import com.zjl.myblog.domain.ReviewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:jlzhang
 * @Description: 文章评论持久层
 * @Date:Created in 2019/12/2
 */
@Repository
public interface ReviewRepository extends JpaRepository<ReviewDO,Integer> {
}
