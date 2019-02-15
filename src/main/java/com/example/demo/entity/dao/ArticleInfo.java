package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章信息
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-07
 */
@TableName("article_info")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("category_id")
    private Integer categoryId;
    @TableField("article_title")
    private String articleTitle;
    @TableField("article_url")
    private String articleUrl;
    @TableField("created_time")
    private Date createdTime;
    @TableField("modified_time")
    private Date modifiedTime;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
        ", id=" + id +
        ", categoryId=" + categoryId +
        ", articleTitle=" + articleTitle +
        ", articleUrl=" + articleUrl +
        ", createdTime=" + createdTime +
        ", modifiedTime=" + modifiedTime +
        ", status=" + status +
        "}";
    }
}
