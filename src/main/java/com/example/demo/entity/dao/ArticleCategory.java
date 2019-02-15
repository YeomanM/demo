package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章分类
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-07
 */
@TableName("article_category")
public class ArticleCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("category_name")
    private String categoryName;
    @TableField("category_code")
    private String categoryCode;
    @TableField("parent_id")
    private Integer parentId;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArticleCategory{" +
        ", id=" + id +
        ", categoryName=" + categoryName +
        ", categoryCode=" + categoryCode +
        ", parentId=" + parentId +
        ", status=" + status +
        "}";
    }
}
