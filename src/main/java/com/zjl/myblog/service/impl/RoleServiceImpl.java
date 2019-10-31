package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.Role;
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
     *@Description: TODO
     *@Date: 2019/10/30 22:56
     *@Param: Role
     *@Return: Role
     */
    @Override
    public Role addRole(Role role) throws Exception{
        Role resRole=roleRepository.save(role);
        if(resRole==null)
        {
            throw new Exception("添加角色失败！");
        }
        return resRole;
    }

    /**
     *@Description: TODO
     *@Date: 2019/10/30 22:57
     *@Param: List<Role>
     *@Return: List<Role>
     */
    @Override
    public List<Role> addRoles(List<Role> roles) throws Exception {
        List<Role> Resroles=roleRepository.saveAll(roles);
        if(Resroles==null||Resroles.size()==0)
        {
            throw new Exception("添加多个角色失败！");
        }
        return Resroles;
    }
}
