package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2018-06-30
 */
@TableName("group_right_rel")
public class GroupRightRel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("group_id")
    private Integer groupId;
    @TableField("right_id")
    private Integer rightId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    @Override
    public String toString() {
        return "GroupRightRel{" +
        ", id=" + id +
        ", groupId=" + groupId +
        ", rightId=" + rightId +
        "}";
    }
}
