package com.zjl.myblog.service;

import com.zjl.myblog.domain.User;


import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
public interface UserService {

    public User addUser(User user) throws Exception;

    public List<User> addUsers(List<User> user) throws Exception;

}
