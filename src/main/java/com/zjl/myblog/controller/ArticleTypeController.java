package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.ArticleTypeDO;
import com.zjl.myblog.service.ArticleTypeService;
import com.zjl.myblog.util.BaseResponseUtil;
import com.zjl.myblog.util.ValidatedUtil;
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
@Api(tags = "文章种类接口")
@RequestMapping("/type")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @Log("添加文章种类")
    @PostMapping
    @ApiOperation(value = "添加种类", notes = "post请求")
    @ApiImplicitParam(paramType = "path", required = true)
    public BaseResponse<ArticleTypeDO> addArticleType(@RequestBody @Validated ArticleTypeDO articleType, BindingResult bindingResult) throws Exception {
        //校验参数
        ValidatedUtil.getBindingResult(bindingResult);
        return BaseResponseUtil.success(articleTypeService.addArticleType(articleType), "添加文章种类成功");
    }

}
