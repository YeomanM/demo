package com.example.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.dao.ArticleCategory;
import com.example.demo.entity.dao.ArticleInfo;
import com.example.demo.entity.dao.ArticlePageView;
import com.example.demo.service.ArticleCategoryService;
import com.example.demo.service.ArticleInfoService;
import com.example.demo.service.ArticlePageViewService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　  ┃
 * ┃　　　━　　  ┃
 * ┃　┳┛　┗┳  ┃
 * ┃　　　　　　  ┃
 * ┃　　　┻　　  ┃
 * ┃　　　　　    ┃
 * ┗━┓　　  ┏━┛
 * 　  ┃　　　┃神兽保佑
 *   　┃　　　┃代码无BUG！
 * 　  ┃　　　┗━━━┓
 * 　  ┃　　　　     ┣┓
 * 　  ┃　　　　　   ┏┛
 * 　  ┗┓┓┏━┓┓┏┛
 * 　    ┃┫┫　┃┫┫
 * 　    ┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2018/9/15
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    ArticleInfoService articleInfoService;

    @Autowired
    ArticlePageViewService articlePageViewService;

    @GetMapping("/article")
    public BaseResponse<?> getArticleStatistics(){

        Map<String,Object> result = new HashMap<>(3);
        int categoryCount = articleCategoryService.selectCount(new EntityWrapper<ArticleCategory>().eq("status","1"));
        result.put("categoryCount",categoryCount);
        int articleCount = articleInfoService.selectCount(new EntityWrapper<ArticleInfo>().eq("status","1"));
        result.put("articleCount",articleCount);
        Map<String,Object> res = articlePageViewService.selectMap(new EntityWrapper<ArticlePageView>()
                .setSqlSelect("article_id,sum(increment) as article_count")
                .groupBy("article_id")
                .orderBy("article_count",false));

        result.put("pageViewCount",res.get("article_count"));
        return ResponseUtil.successResponse(result);
    }

    @GetMapping("/chart")
    public BaseResponse<?> getChartData(){

        List<ArticleCategory> topCategory = articleCategoryService.selectList(
                new EntityWrapper<ArticleCategory>()
                .eq("parent_id","0")
        );

        Object[] objects = new Object[topCategory.size()];
        for (int i = 0,len = objects.length;i < len; i++){
            objects[i] = topCategory.get(i);
        }

        List<Map<String,Object>> res = articleInfoService.selectMapsPage(
                new Page<>(1,5),
                new EntityWrapper<ArticleInfo>()
                .setSqlSelect("left(created_time,7) as time,count(id) AS count,category_id")
                .in("category_id",objects)
                .groupBy("time,category_id")
                .orderBy("category_id,time")
        ).getRecords();

        List<String> catrgory = new ArrayList<>();
        res.forEach(r -> {

        });

        return ResponseUtil.successResponse(res);
    }

    @GetMapping("/account")
    public BaseResponse<?> getAccountStatData(){
        return ResponseUtil.successResponse();
    }

}
