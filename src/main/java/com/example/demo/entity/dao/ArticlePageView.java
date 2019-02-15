package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章浏览量
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-07
 */
@TableName("article_page_view")
public class ArticlePageView implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("article_id")
    private Integer articleId;
    private Integer increment;
    @TableField("statistics_date")
    private Date statisticsDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    @Override
    public String toString() {
        return "ArticlePageView{" +
        ", id=" + id +
        ", articleId=" + articleId +
        ", increment=" + increment +
        ", statisticsDate=" + statisticsDate +
        "}";
    }
}
