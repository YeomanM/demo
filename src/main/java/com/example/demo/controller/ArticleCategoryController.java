package com.example.demo.controller;


import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.ArticleCategory;
import com.example.demo.service.ArticleCategoryService;
import com.example.demo.utils.ResponseUtil;
import com.yeoman.file.PinyinUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-06
 */
@RestController
@RequestMapping(value = "/articleCategory")
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @PutMapping
    public BaseResponse<?> addCategory(@Valid @RequestBody ArticleCategory category) throws BadHanyuPinyinOutputFormatCombination {
        if (category.getId() == null){
            String categoryCode = PinyinUtil.toPinyin(category.getCategoryName());
            category.setCategoryCode(categoryCode);
        }
        articleCategoryService.insertOrUpdate(category);
        return ResponseUtil.successResponse();
    }

    @GetMapping("/tree")
    public BaseResponse<?> getCategoryTree(){
        Map<String,Object> result = new HashMap<>(4);
        result.put("id",0);
        result.put("categoryName","root");
        result.put("disabled",true);
        result.put("child",articleCategoryService.getCategoryTree(0));
        return ResponseUtil.successResponse(new ArrayList<Object>(){{add(result);}});
    }

    @DeleteMapping("/{categoryId}")
    public BaseResponse<?> deleteCategory(@PathVariable String categoryId){
        ArticleCategory category = articleCategoryService.selectById(categoryId);
        category.setStatus(0);
        articleCategoryService.updateById(category);
        return ResponseUtil.successResponse();
    }
}

