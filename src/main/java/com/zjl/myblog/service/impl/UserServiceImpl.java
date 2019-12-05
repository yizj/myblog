package com.zjl.myblog.service.impl;

import com.zjl.myblog.domain.Action;
import com.zjl.myblog.domain.Role;
import com.zjl.myblog.domain.User;
import com.zjl.myblog.domain.UserDto;
import com.zjl.myblog.jmsconsumer.dto.EmailJmsDto;
import com.zjl.myblog.jmsproducer.JmsProducer;
import com.zjl.myblog.repository.UserRepository;
import com.zjl.myblog.service.RedisService;
import com.zjl.myblog.service.UserService;
import com.zjl.myblog.utils.BeanConvertUtil;
import com.zjl.myblog.utils.JsonClassConvertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RedisService redisService;

    @Resource
    private JmsProducer jmsProducer;

    @Override
    public User addUser(User user) throws Exception {
        Role role = new Role();
        Action action = new Action();
        action.setActiobUrl("/admin");
        action.setActionName("普通用户权限");
        role.setRoleName("ROLE_USER");
        role.getActions().add(action);
        user.getRoles().add(role);
        User resUser = userRepository.save(user);
        if (resUser == null) {
            throw new Exception("添加用户失败！");
        }
        sendJms ( user );
        return resUser;
    }

    @Override
    public List<User> addUsers(List<User> users) throws Exception {
        List<User> resUsers = userRepository.saveAll(users);
        if (resUsers == null || resUsers.size() == 0) {
            throw new Exception("添加多个用户失败！");
        }
        return resUsers;
    }
    /**
      *
      * 用户登录
      *
      * @exception
      */
    @Override
    public UserDto userLogin(String userEmail, String userPwd) {
        User user=userRepository.findUserByUserEmailAndUserPwd (userEmail, userPwd );
        if (user == null) {
            throw new RuntimeException ( "该用户不存在，请核对用户名密码是否正确" );
        }
        // 对象转换
        UserDto userDto=BeanConvertUtil.convert(user,UserDto.class);
        // 生成token
        String token=UUID.randomUUID ().toString ();
        userDto.setToken (token);
        // 转换成json
        String value= JsonClassConvertUtil.classToString(userDto);
        // 保存到redis
        redisService.set(token,value);
        // 设置过期时间
        redisService.expire(token,30*60);
        return userDto;
    }

    private void sendJms(User user){
        EmailJmsDto emailJmsDto=new EmailJmsDto ();
        emailJmsDto.setTo ( user.getUserEmail () );
        emailJmsDto.setSubject ("请点击下面超链接完成邮箱激活");
        emailJmsDto.setContent ( "<div><a href=${pageContext.request.contextPath }/user?method=registUI>激活</a></div>" );
        jmsProducer.send ( "EMAIL",
                "ACTIVE" ,
                JsonClassConvertUtil.classToString ( emailJmsDto )
        );
    }
}
