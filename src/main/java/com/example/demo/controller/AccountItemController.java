package com.example.demo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.constants.ErrorType;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.AccountItem;
import com.example.demo.entity.dao.AccountTag;
import com.example.demo.service.AccountItemService;
import com.example.demo.service.AccountTagService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 账单详细信息 前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@RestController
@RequestMapping("/accountItem")
public class AccountItemController {

    @Autowired
    private AccountItemService accountItemService;

    @Autowired
    private AccountTagService accountTagService;

    @GetMapping("/page")
    public BaseResponse<?> pageAccountItem(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "10") int rows){
        return ResponseUtil.successResponse(accountItemService.selectPage(new Page<>(page,rows)));
    }

    @PostMapping
    public BaseResponse<?> addAccount(@Valid AccountItem item) throws ParseException {
        AccountTag tag = accountTagService.selectById(item.getTagId());
        if (tag == null){
            return ResponseUtil.errorResponse(ErrorType.PARAM_LOST);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = item.getCreatedDate();
        if (now == null){
            now = new Date();
        }
        String nowStr = sdf.format(now);
        now = sdf.parse(nowStr);
        item.setCreatedDate(now);
        accountItemService.insertAllColumn(item);
        return ResponseUtil.successResponse();
    }

}

