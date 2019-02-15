package com.example.demo.config;

import com.example.demo.entity.dao.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *   ┏┓　　　┏┓
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
public class FriendShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public final static Logger LOGGER = LoggerFactory.getLogger(FriendShiroRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();





        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        List<User> users = userService.selectByMap(map);

        if (users == null || users.size() != 1){
            return null;
        }

        SessionsSecurityManager securityManager = (SessionsSecurityManager) SecurityUtils.getSecurityManager();
        DefaultSessionManager sessionManager = (DefaultSessionManager) securityManager.getSessionManager();

        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();

        User user = null;
        for (Session session : sessions){
            user = (User) session.getAttribute("user");
            if (user != null && username.equals(user.getUsername()) && password.equals(user.getPassword())){
                if (SecurityUtils.getSubject().getSession().getId().equals(session.getId())){
                    break;
                } else {
                    sessionManager.getSessionDAO().delete(session);
                    LOGGER.info("{} 已登陆，移除已保存的session");
                }
            }
        }



        user = users.get(0);
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
