package com.example.demo.service;

import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.Right;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yeoman123
 * @since 2019-01-20
 */
public interface RightService extends IService<Right> {

    BaseResponse getRightTree(Integer userId);

    Object getRightTreeByGroup(Integer groupId);

    BaseResponse getAllRight();

}
