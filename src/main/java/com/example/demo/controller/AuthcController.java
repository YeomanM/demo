package com.example.demo.controller;

import com.example.demo.entity.BaseResponse;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RestController
@RequestMapping(value = "/authc" )
public class AuthcController {

    @Autowired
    private UserService userService;

    public final static Logger LOGGER = LoggerFactory.getLogger(AuthcController.class);

    @RequestMapping(value = "/login",produces = "application/json" ,method = RequestMethod.POST)
    public BaseResponse login(@RequestParam("username")String username,@RequestParam("password")String password){

        LOGGER.info("username = {} , password = {} " , username ,password);

        return userService.login(username,password);
    }




}
