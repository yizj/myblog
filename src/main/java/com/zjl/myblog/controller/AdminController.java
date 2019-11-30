package com.zjl.myblog.controller;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.User;
import com.zjl.myblog.service.UserService;
import com.zjl.myblog.utils.BaseResponseUtil;
import com.zjl.myblog.utils.ValidatedUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/10
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员接口")
public class AdminController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加管理员", notes = "post请求")
    @ApiImplicitParam(paramType = "path", required = true)
    @PostMapping
    public BaseResponse<User> addUser(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
        //校验参数
        ValidatedUtils.getBindingResult(bindingResult);
        //添加用户校验信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserEmail(),
                user.getUserPwd()
        );
        subject.login(usernamePasswordToken);
        return BaseResponseUtil.success(userService.addUser(user), "添加管理员成功");
    }
}
