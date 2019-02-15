package com.example.demo.service;

import com.example.demo.entity.dao.AccountTag;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 账单标签 服务类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
public interface AccountTagService extends IService<AccountTag> {

    /**
     * 根据父节点获取分类树
     * @param pId 父节点id
     * @return 分类树
     */
    List<Object> getAccountTagTree(int pId);

}
