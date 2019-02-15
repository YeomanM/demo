package com.example.demo.filter;


import com.alibaba.fastjson.JSONArray;
import com.example.demo.constants.ErrorType;
import com.example.demo.utils.ResponseUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description : 用于shiro的session过期的拦截，直接返回json数据，不跳转，不用配置loginUrl，
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2018/7/31
 */
public class ShiroLoginFilter extends FormAuthenticationFilter {

    /**
     * 需要返回false，不然会报错
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        HttpServletResponse httpServletResponse;
        httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSONArray.toJSONString(ResponseUtil.errorResponse(ErrorType.AUTHC_UN_LOGIN)));
        writer.close();
        return false;
    }

}
