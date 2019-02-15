package com.example.demo.mapper;

import com.example.demo.entity.dao.AccountItem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账单详细信息 Mapper 接口
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@Mapper
public interface AccountItemMapper extends BaseMapper<AccountItem> {

}
