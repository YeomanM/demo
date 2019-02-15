package com.example.demo.service.impl;

import com.example.demo.aspect.InfoAnnotation;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.utils.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse login(String name,String password) {

        Map<String,Object> map = new HashMap<>(1);
        map.put("username",name);

        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        Subject subject = SecurityUtils.getSubject();

        subject.login(token);

        return ResponseUtil.successResponse(userMapper.selectByMap(map));
    }

    @Override
    public BaseResponse<?> test(@InfoAnnotation String userId) {
        return ResponseUtil.successResponse(userId);
    }
}
