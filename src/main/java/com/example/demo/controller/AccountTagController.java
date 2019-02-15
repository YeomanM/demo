package com.example.demo.controller;


import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.AccountTag;
import com.example.demo.service.AccountTagService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 账单标签 前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@RestController
@RequestMapping("/accountTag")
public class AccountTagController {

    @Autowired
    private AccountTagService accountTagService;


    @GetMapping("/tree")
    public BaseResponse<?> getAccountTagTree(){
        Map<String,Object> result = new HashMap<>(4);
        result.put("tagId",0);
        result.put("tagName","account");
        result.put("disabled",true);
        result.put("child",accountTagService.getAccountTagTree(0));
        return ResponseUtil.successResponse(new ArrayList<Object>(){{add(result);}});
    }

    @PutMapping
    public BaseResponse<?> addAccountTag(@Valid @RequestBody AccountTag tag){
        accountTagService.insertOrUpdate(tag);
        return ResponseUtil.successResponse();
    }


}

