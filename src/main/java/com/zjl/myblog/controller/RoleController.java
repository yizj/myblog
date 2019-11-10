package com.zjl.myblog.controller;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.Role;
import com.zjl.myblog.service.RoleService;
import com.zjl.myblog.utils.BaseResponseUtil;
import com.zjl.myblog.utils.ValidatedUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jlzhang
 * @Description: 角色控制器
 * @Date:Created in 2019/10/30
 */
@RestController
@RequestMapping(value = "/role")
@Api(tags = "角色接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "添加角色",notes = "post请求")
    @ApiImplicitParam(paramType = "path",name = "roleName",value="角色名称",required =true )
    @PostMapping
    public BaseResponse<Role> addRole(@RequestBody @Validated Role role, BindingResult bindingResult) throws Exception
    {
        //校验参数
        ValidatedUtils.getBindingResult(bindingResult);
        return BaseResponseUtil.success(roleService.addRole(role),"添加角色成功");
    }
}
