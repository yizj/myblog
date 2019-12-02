package com.zjl.myblog.service;

import com.zjl.myblog.domain.Review;

public interface ReviewService {

        /**
          * 发表评论
          * @exception
          */
        Review addReview(Review review);
}
