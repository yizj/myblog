package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.Action;
import com.zjl.myblog.domain.Role;
import com.zjl.myblog.domain.User;
import com.zjl.myblog.repository.UserRepository;
import com.zjl.myblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public User addUser(User user) throws Exception {
        Role role=new Role();
        Action action=new Action();
        action.setActiobUrl("/admin");
        action.setActionName("普通用户权限");
        role.setRoleName("ROLE_USER");
        role.getActions().add(action);
        user.getRoles().add(role);
        User resUser=userRepository.save(user);

        if(resUser==null)
        {
            throw new Exception("添加用户失败！");
        }
        return resUser;
    }

    @Override
    public List<User> addUsers(List<User> users) throws Exception {

        List<User> resUsers=userRepository.saveAll(users);
        if(resUsers==null||resUsers.size()==0)
        {
            throw new Exception("添加多个用户失败！");
        }
        return resUsers;
    }
}