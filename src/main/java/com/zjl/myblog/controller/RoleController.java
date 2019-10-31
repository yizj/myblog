package com.zjl.myblog.controller;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.domain.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jlzhang
 * @Description: 角色控制器
 * @Date:Created in 2019/10/30
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @PostMapping(value = "/add")
    public BaseResponse<Role> addRole()
    {

    }
}
