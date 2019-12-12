package com.zjl.myblog.service;

import com.zjl.myblog.domain.UserDO;
import com.zjl.myblog.dto.UserDto;


import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
public interface UserService {

     UserDO addUser(UserDO user) throws Exception;

     List<UserDO> addUsers(List<UserDO> user) throws Exception;

     UserDto userLogin(String userEmail, String userPwd);

}
