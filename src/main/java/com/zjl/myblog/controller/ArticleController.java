package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.ArticleDO;
import com.zjl.myblog.dto.ArticleDto;
import com.zjl.myblog.service.ArticleService;
import com.zjl.myblog.util.BaseResponseUtil;
import com.zjl.myblog.util.ValidatedUtil;
import com.zjl.myblog.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public BaseResponse<ArticleDO> saveArticle(@Validated @RequestBody ArticleDO article,
                                               BindingResult bindingResult,
                                               HttpServletRequest request
                                               ) throws Exception {
        // 验证
        ValidatedUtil.getBindingResult(bindingResult);
        return  BaseResponseUtil.success(articleService.addArticle(article,request),"文章发布成功");
    }

    @Log("查询所有文章并分页")
    @ApiOperation(value = "查询所有文章并分页",notes = "get请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @GetMapping("/all")
    public BaseResponse<Page<ArticleDO>> listAllArticle(PageVO pageVO){

        return  BaseResponseUtil.success(articleService.listArticles ( pageVO ),
                "文章查询成功");
    }

    @Log("查询满足条件的文章并分页")
    @ApiOperation(value = "查询满足条件的文章并分页",notes = "get请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @GetMapping("/condition")
    public BaseResponse<Page<ArticleDO>> listConditionArticle(PageVO pageVO,ArticleDto articleDto){

        return  BaseResponseUtil.success(articleService.listArticlesByCondition ( pageVO ,articleDto),
                "文章查询成功");
    }

}
