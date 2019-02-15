package com.example.demo.mapper;

import com.example.demo.entity.dao.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
