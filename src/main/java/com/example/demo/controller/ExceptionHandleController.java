package com.example.demo.controller;

import com.example.demo.entity.BaseResponse;
import com.example.demo.exception.BaseException;
import com.example.demo.utils.ResponseUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @Date : Create in 2018/7/4
 */
@ControllerAdvice
public class ExceptionHandleController {

    @ModelAttribute
    public void addAttribute(Model model){
        //可以添加东西
    }

    @ResponseBody
    @ExceptionHandler
    public BaseResponse exceptionHandler(Exception e){

        e.printStackTrace();
        if (e instanceof BaseException){
            return ResponseUtil.errorResponse(((BaseException) e).getErrCode(),((BaseException) e).getErrMsg());
        } else {
            return ResponseUtil.errorResponse(-1,e.getClass().getName());
        }
    }

}
