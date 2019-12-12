package com.zjl.myblog.controller;

import com.zjl.myblog.annotation.Log;
import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.RoleDO;
import com.zjl.myblog.service.RoleService;
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
    @Log("角色添加")
    public BaseResponse<RoleDO> saveRole(@RequestBody @Validated RoleDO role, BindingResult bindingResult) throws Exception
    {
        //校验参数
        ValidatedUtil.getBindingResult(bindingResult);
        return BaseResponseUtil.success(roleService.addRole(role),"添加角色成功");
    }
}
