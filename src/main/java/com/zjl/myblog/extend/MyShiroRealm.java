package com.zjl.myblog.extend;

import com.zjl.myblog.domain.User;
import com.zjl.myblog.repository.UserRepository;
import com.zjl.myblog.utils.LogUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @Author:jlzhang
 * @Description: 实现AuthorizingRealm接口用户用户认证
 * @Date:Created in 2019/11/10
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LogUtil.info(MyShiroRealm.class, "开始执行认证方法:参数是{0}", token);
        User user = userRepository.findByUserEmail(token.getUsername());
        String name = authenticationToken.getPrincipal().toString();
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getUserPwd(), getName());
        return simpleAuthenticationInfo;
    }
}
