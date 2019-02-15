package com.example.demo.controller;

import com.example.demo.constants.ErrorType;
import com.example.demo.entity.BaseResponse;
import com.example.demo.utils.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/error",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ErrorController {

    @RequestMapping("/unauthc")
    public BaseResponse unAuthc(){
        return ResponseUtil.errorResponse(ErrorType.AUTHC_UN_LOGIN);
    }


}
