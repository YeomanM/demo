package com.example.demo.entity.dao;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 账单详细信息
 * </p>
 *
 * @author Yeoman123
 * @since 2018-09-18
 */
@TableName("account_item")
public class AccountItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("item_id")
    private Integer itemId;
    @TableField("tag_id")
    @NotNull
    private Integer tagId;
    @TableField("created_date")
    private Date createdDate;
    @NotNull
    @TableField("account_amount")
    private Integer accountAmount;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Integer accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Override
    public String toString() {
        return "AccountItem{" +
        ", itemId=" + itemId +
        ", tagId=" + tagId +
        ", createdDate=" + createdDate +
        ", accountAmount=" + accountAmount +
        "}";
    }
}
