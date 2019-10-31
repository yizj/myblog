package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.Role;
import com.zjl.myblog.repository.RoleRepository;
import com.zjl.myblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     *@Description: TODO
     *@Date: 2019/10/30 22:56
     *@Param: Role
     *@Return: Role
     */
    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     *@Description: TODO
     *@Date: 2019/10/30 22:57
     *@Param: List<Role>
     *@Return: List<Role>
     */
    @Override
    public List<Role> addRoles(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }
}
