package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.dao.AccountTag;
import com.example.demo.mapper.AccountTagMapper;
import com.example.demo.service.AccountTagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单标签 服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@Service
public class AccountTagServiceImpl extends ServiceImpl<AccountTagMapper, AccountTag> implements AccountTagService {

    @Override
    public List<Object> getAccountTagTree(int pId) {
        Map<String,Object> params = new HashMap<>(1);
        params.put("tag_parent_id",pId);
        List<AccountTag> categories = this.selectByMap(params);
        List<Object> result = new ArrayList<>(categories.size());
        categories.forEach(category -> {
            Map<String,Object> map = (Map<String, Object>) JSON.toJSON(category);
            map.put("child",this.getAccountTagTree(category.getTagId()));
            result.add(map);
        });
        return result;
    }
}
