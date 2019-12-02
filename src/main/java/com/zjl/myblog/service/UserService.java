package com.zjl.myblog.service;

import com.zjl.myblog.domain.User;
import com.zjl.myblog.domain.UserDto;


import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
public interface UserService {

     User addUser(User user) throws Exception;

     List<User> addUsers(List<User> user) throws Exception;

     UserDto registUser(String userEmail, String userPwd);

}
