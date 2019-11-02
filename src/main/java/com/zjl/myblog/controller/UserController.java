package com.zjl.myblog.controller;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.Role;
import com.zjl.myblog.domain.User;
import com.zjl.myblog.service.UserService;
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
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户",notes = "post请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @PostMapping
    public BaseResponse<User> addUser(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
        //校验参数
        ValidatedUtils.getBindingResult(bindingResult);
        return BaseResponseUtil.success(userService.addUser(user),"添加用户成功");
    }
}
