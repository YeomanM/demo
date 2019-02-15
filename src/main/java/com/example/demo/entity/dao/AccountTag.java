package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 账单标签
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@TableName("account_tag")
public class AccountTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("tag_id")
    private Integer tagId;
    @TableField("tag_name")
    @NotBlank
    private String tagName;
    @TableField("tag_parent_id")
    private Integer tagParentId;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagParentId() {
        return tagParentId;
    }

    public void setTagParentId(Integer tagParentId) {
        this.tagParentId = tagParentId;
    }

    @Override
    public String toString() {
        return "AccountTag{" +
        ", tagId=" + tagId +
        ", tagName=" + tagName +
        ", tagParentId=" + tagParentId +
        "}";
    }
}
