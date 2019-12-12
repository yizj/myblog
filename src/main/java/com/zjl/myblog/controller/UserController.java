package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.UserDO;
import com.zjl.myblog.dto.UserDto;
import com.zjl.myblog.service.UserService;
import com.zjl.myblog.util.BaseResponseUtil;
import com.zjl.myblog.util.ValidatedUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Log("用户注册")
    @ApiOperation(value = "添加用户",notes = "post请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @PostMapping
    public BaseResponse<UserDO> addUser(@RequestBody @Validated UserDO user, BindingResult bindingResult) throws Exception {
        // 校验参数
        ValidatedUtil.getBindingResult(bindingResult);
        return BaseResponseUtil.success(userService.addUser(user),"添加用户成功");
    }

    @Log("用户登录")
    @ApiOperation(value = "用户登录",notes = "get请求")
    @ApiImplicitParam(paramType = "path",required = true)
    @GetMapping
    public BaseResponse<UserDto> loginUser(String userEmail, String userPwd) throws Exception {
        return BaseResponseUtil.success(
                userService.userLogin(userEmail,userPwd),
                "用户登录成功");
    }
}
