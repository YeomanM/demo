package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yeoman123
 * @since 2019-01-26
 */
@TableName("j_user_group")
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户组ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户组名称
     */
    @TableField("group_name")
    private String groupName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;
    /**
     * 更新人
     */
    private String updator;
    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;
    private String email;

    @TableField("group_desc")
    private String groupDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
        ", id=" + id +
        ", groupName=" + groupName +
        ", creator=" + creator +
        ", createdTime=" + createdTime +
        ", updator=" + updator +
        ", updatedTime=" + updatedTime +
        ", email=" + email +
        ", groupDesc=" + groupDesc +
        "}";
    }
}
