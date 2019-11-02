package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.User;
import com.zjl.myblog.repository.UserRepository;
import com.zjl.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) throws Exception {
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
