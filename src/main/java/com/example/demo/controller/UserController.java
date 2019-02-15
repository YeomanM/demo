package com.example.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.aspect.InfoAnnotation;
import com.example.demo.constants.ErrorType;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public BaseResponse<?> getPageUser(@RequestParam int page,@RequestParam int rows){
        Page<User> userPage = new Page<>(page,rows);
        userPage = userService.selectPage(userPage);
        return ResponseUtil.successResponse(userPage);
    }

    @GetMapping("/search")
    public BaseResponse<?> searchUser(@RequestParam(required = false) String username,
                                      @RequestParam(required = false) String email){
        Map<String,Object> map = new HashMap<>(2);
        if (!"".equals(username)){
            map.put("username",username);
        }
        if (!"".equals(email)){
            map.put("email",email);
        }
        if (map.isEmpty()){
            return ResponseUtil.errorResponse(ErrorType.PARAM_LOST);
        }
        return ResponseUtil.successResponse(userService.selectByMap(map));
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping
    public BaseResponse<?> addUser(@Valid User user){
        User u = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String password = user.getPassword();
        password = new SimpleHash("md5",password,user.getUsername(),1).toBase64();
        user.setPassword(password);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setCreator(u.getUsername());
        user.setUpdator(u.getUsername());
        user.setUpdatedTime(date);
        userService.insert(user);
        return ResponseUtil.successResponse();
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping
    public BaseResponse<?> updateUser(@Valid User user){
        User u = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String password = user.getPassword();
        password = new SimpleHash("md5",password,user.getUsername(),1).toBase64();
        user.setPassword(password);
        Date date = new Date();
        user.setUpdator(u.getUsername());
        user.setUpdatedTime(date);
        userService.updateById(user);
        return ResponseUtil.successResponse();
    }

}

