package com.example.demo.service;

import com.example.demo.entity.dao.ArticleCategory;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-06
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {


    /**
     * 根据父节点获取分类树
     * @param pId 父节点id
     * @return 分类树
     */
    List<Object> getCategoryTree(int pId);


}
