package com.example.demo.service.impl;

import com.example.demo.entity.dao.AccountItem;
import com.example.demo.mapper.AccountItemMapper;
import com.example.demo.service.AccountItemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账单详细信息 服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@Service
public class AccountItemServiceImpl extends ServiceImpl<AccountItemMapper, AccountItem> implements AccountItemService {

}
