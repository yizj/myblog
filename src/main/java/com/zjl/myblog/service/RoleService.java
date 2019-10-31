package com.zjl.myblog.service;

import com.zjl.myblog.domain.Role;

import java.util.List;

public interface RoleService {

    public Role addRole(Role role) throws Exception;

    public List<Role> addRoles(List<Role> roles) throws Exception;

}
