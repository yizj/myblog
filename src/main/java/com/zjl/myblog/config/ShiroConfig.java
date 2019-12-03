package com.zjl.myblog.config;

import com.zjl.myblog.extend.MyShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/11/10
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "myShiroRealm")
    MyShiroRealm myShiroRealm() {
        return new MyShiroRealm ( );
    }

    @Bean(name = "securityManager")
    DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myShiroRealm") MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager ( );
        securityManager.setRealm ( myShiroRealm );
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean ( );
        shiroFilterFactoryBean.setSecurityManager ( defaultWebSecurityManager );
        Map filterMap = new LinkedHashMap ( );
        filterMap.put ( "/login", "anon" );
        filterMap.put ( "/role", "authc" );
        shiroFilterFactoryBean.setLoginUrl ( "/admin" );
        shiroFilterFactoryBean.setFilterChainDefinitionMap ( filterMap );
        return shiroFilterFactoryBean;
    }

}
