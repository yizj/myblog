package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.Review;
import com.zjl.myblog.repository.ReviewRepository;
import com.zjl.myblog.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/2
 * @date: 2019/12/2
 * @function: TODO
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        Review resReview = reviewRepository.save(review);
        if (resReview == null) {
            throw new RuntimeException ( "发表评论失败！" );
        }
        return resReview;
    }
}
