package com.example.demo.service;

import com.example.demo.aspect.InfoAnnotation;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@Service
public interface UserService extends IService<User> {

    BaseResponse login(String username,String password);

//    BaseResponse<?> searchByCondition(Map<String,Object> params,int page,int rows);

    BaseResponse<?> test(@InfoAnnotation String userId);

}
