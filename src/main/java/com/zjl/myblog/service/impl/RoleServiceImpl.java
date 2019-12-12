package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.RoleDO;
import com.zjl.myblog.repository.RoleRepository;
import com.zjl.myblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * @Description: TODO
     * @Date: 2019/10/30 22:56
     * @Param: Role
     * @Return: Role
     */
    @Override
    public RoleDO addRole(RoleDO role) throws Exception {
        RoleDO resRole = roleRepository.save(role);
        if (resRole == null) {
            throw new Exception("添加角色失败！");
        }
        return resRole;
    }

    /**
     * @Description: TODO
     * @Date: 2019/10/30 22:57
     * @Param: List<Role>
     * @Return: List<Role>
     */
    @Override
    public List<RoleDO> addRoles(List<RoleDO> roles) throws Exception {
        List<RoleDO> resRoles = roleRepository.saveAll(roles);
        if (resRoles == null || resRoles.size() == 0) {
            throw new Exception("添加多个角色失败！");
        }
        return resRoles;
    }
}
