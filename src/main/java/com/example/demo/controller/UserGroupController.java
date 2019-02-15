package com.example.demo.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.UserGroup;
import com.example.demo.service.UserGroupService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2019-01-26
 */
@RestController
@RequestMapping("/userGroup")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("/page")
    public BaseResponse<Object> getPageGroup(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int rows){
        return ResponseUtil.successResponse(userGroupService.selectPage(new Page<>(page,rows)));
    }


}

