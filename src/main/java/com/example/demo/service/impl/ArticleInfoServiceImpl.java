package com.example.demo.service.impl;

import com.example.demo.entity.dao.ArticleInfo;
import com.example.demo.mapper.ArticleInfoMapper;
import com.example.demo.service.ArticleInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章信息 服务实现类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-07
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

}
