package com.example.demo.utils;

import com.example.demo.constants.ErrorType;
import com.example.demo.entity.BaseResponse;

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
public class ResponseUtil {

    public static BaseResponse errorResponse(int errCode,String errMsg){
        BaseResponse response = new BaseResponse();
        response.setErrCode(errCode);
        response.setErrMsg(errMsg);
        return response;
    }

    public static BaseResponse errorResponse(ErrorType errorType){
        return ResponseUtil.errorResponse(errorType.getErrCode(), errorType.getErrMsg());
    }

    public static BaseResponse successResponse(){
        return ResponseUtil.successResponse(null,null);
    }

    public static BaseResponse successResponse(Object data){
        return ResponseUtil.successResponse("",data);
    }

    public static BaseResponse successResponse(String errMsg){
        return ResponseUtil.successResponse(errMsg,null);
    }

    public static BaseResponse successResponse(String errMsg,Object data){
        BaseResponse response = new BaseResponse();
        response.setErrCode(0);
        response.setErrMsg(errMsg);
        response.setData(data);
        return response;
    }


}
