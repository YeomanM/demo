package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.dao.ArticleCategory;
import com.example.demo.mapper.ArticleCategoryMapper;
import com.example.demo.service.ArticleCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-06
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements ArticleCategoryService {



    @Override
    public List<Object> getCategoryTree(int pId) {

        Map<String,Object> params = new HashMap<>(1);
        params.put("parent_id",pId);
        List<ArticleCategory> categories = this.selectByMap(params);
        List<Object> result = new ArrayList<>(categories.size());
        categories.forEach(category -> {
            Map<String,Object> map = (Map<String, Object>) JSON.toJSON(category);
            map.put("child",this.getCategoryTree(category.getId()));
            result.add(map);
        });
        return result;
    }
}
