package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.Article;
import com.zjl.myblog.service.ArticleService;
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

@RestController
@Api(tags = "文章接口")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Log("添加文章")
    @ApiOperation(value = "发布文章",notes = "post请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @PostMapping
    public BaseResponse<Article> addArticle(@Validated @RequestBody Article article, BindingResult bindingResult) throws Exception {
        //验证
        ValidatedUtils.getBindingResult(bindingResult);
        return  BaseResponseUtil.success(articleService.addArticle(article),"文章发布成功");
    }

}
