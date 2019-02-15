package com.example.demo.config;

import com.example.demo.filter.ShiroLoginFilter;
import com.example.demo.filter.ShiroPermissionsFilter;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　  ┃
 * ┃　　　━　　  ┃
 * ┃　┳┛　┗┳  ┃
 * ┃　　　　　　  ┃
 * ┃　　　┻　　  ┃
 * ┃　　　　　    ┃
 * ┗━┓　　  ┏━┛
 * 　  ┃　　　┃神兽保佑
 * 　  ┃　　　┃代码无BUG！
 * 　  ┃　　　┗━━━┓
 * 　  ┃　　　　     ┣┓
 * 　  ┃　　　　　   ┏┛
 * 　  ┗┓┓┏━┓┓┏┛
 * 　    ┃┫┫　┃┫┫
 * 　    ┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2018/6/30
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/authc/*","anon");
        filterChainDefinitionMap.put("/authc/logout","logout");
//        filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/**","anon");



        Map<String,Filter> filters = bean.getFilters();
        filters.put("authc",new ShiroLoginFilter());
        filters.put("perms",new ShiroPermissionsFilter());

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }


    @Bean
    public FriendShiroRealm friendShiroRealm(){
        FriendShiroRealm realm = new FriendShiroRealm();
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(friendShiroRealm());
        manager.setSessionManager(getDefaultWebSessionManager());
        return manager;
    }

    /**
     * 开启shiro的AOP，需要代码开启，不然不能执行realm的代码
     * @param securityManager 在securityManager()注入，使用自定义realm
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public MemorySessionDAO getMemorySessionDAO(){
        return new MemorySessionDAO();
    }

    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(getMemorySessionDAO());
        return sessionManager;
    }


}
