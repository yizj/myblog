package com.zjl.myblog.service.impl;

import com.zjl.myblog.constant.ServiceConsts;
import com.zjl.myblog.domain.ActionDO;
import com.zjl.myblog.domain.RoleDO;
import com.zjl.myblog.domain.UserDO;
import com.zjl.myblog.dto.UserDto;
import com.zjl.myblog.jmsconsumer.dto.EmailJmsDto;
import com.zjl.myblog.jmsproducer.JmsProducer;
import com.zjl.myblog.repository.UserRepository;
import com.zjl.myblog.service.RedisService;
import com.zjl.myblog.service.UserService;
import com.zjl.myblog.util.BeanConvertUtil;
import com.zjl.myblog.util.JsonClassConvertUtil;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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

    @Resource
    private TemplateEngine templateEngine;

    @Override
    public UserDO addUser(UserDO user) throws Exception {
        RoleDO role = new RoleDO ();
        ActionDO action = new ActionDO ();
        action.setActiobUrl("/admin");
        action.setActionName("普通用户权限");
        role.setRoleName("ROLE_USER");
        role.getActionDOS ().add(action);
        user.getRoleDOS ().add(role);
        UserDO resUser = userRepository.save(user);
        if (resUser == null) {
            throw new Exception("添加用户失败！");
        }
        sendJms ( user );
        return resUser;
    }

    @Override
    public List<UserDO> addUsers(List<UserDO> users) throws Exception {
        List<UserDO> resUsers = userRepository.saveAll(users);
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
        UserDO user=userRepository.findUserByUserEmailAndUserPwd (userEmail, userPwd );
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

    private void sendJms(UserDO user){
        Context context=new Context();
        context.setVariable("username",user.getUserName());
        context.setVariable("phone",user.getUserPhone());
        String mail=templateEngine.process("mailtemplate.html",context);
        EmailJmsDto emailJmsDto=new EmailJmsDto ();
        emailJmsDto.setTo ( user.getUserEmail () );
        emailJmsDto.setSubject (ServiceConsts.EMAIL_SUBJECT );
        emailJmsDto.setContent (mail );
        jmsProducer.send ( ServiceConsts.EMAIL_TYPE,
                ServiceConsts.EMAIL_STEP ,
                JsonClassConvertUtil.classToString ( emailJmsDto )
        );
    }
}
