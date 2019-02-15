package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constants.ErrorType;
import com.example.demo.utils.ResponseUtil;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description : 没有权限的拦截器
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2018/7/31
 */
public class ShiroPermissionsFilter extends PermissionsAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSONObject.toJSONString(ResponseUtil.errorResponse(ErrorType.AUTHC_UN_LOGIN)));
        writer.close();
        return false;
    }

}
