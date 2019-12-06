package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.Review;
import com.zjl.myblog.service.ReviewService;
import com.zjl.myblog.utils.BaseResponseUtil;
import com.zjl.myblog.utils.ValidatedUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/2
 * @date: 2019/12/2
 * @function: TODO
 */
@RestController
@Api(tags = "文章评论接口")
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Log("发布文章")
    @ApiOperation ( value = "发布文章评论",notes = "POST请求")
    @PostMapping
    @ApiImplicitParam(paramType = "path" ,required = true)
    public BaseResponse<Review> addReview(@RequestBody @Validated Review review, BindingResult bindingResult) throws Exception {
        //校验参数
        ValidatedUtils.getBindingResult(bindingResult);
        return BaseResponseUtil.success (reviewService.addReview(review),"发布评论成功");
    }
}
