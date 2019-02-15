package com.example.demo.aspect.resoler;

import com.example.demo.aspect.InfoAnnotation;
import com.example.demo.constants.SystemConts;
import com.example.demo.entity.dao.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

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
 *   　┃　　　┃代码无BUG！
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
 * @Date : Create in 2018/7/26
 */
public class InfoResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(InfoAnnotation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        InfoAnnotation annotation = methodParameter.getParameterAnnotation(InfoAnnotation.class);
        String value = annotation.value();

        if (value == null || "".equalsIgnoreCase(value) || value.equalsIgnoreCase("userId")){
            User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
            if (user == null){
                return 1;
            }
            return user.getId();
        } else if (SystemConts.SYS_USER.toString().equalsIgnoreCase(value)){
            return SecurityUtils.getSubject().getSession().getAttribute("user");
        }

        return value;
    }
}
