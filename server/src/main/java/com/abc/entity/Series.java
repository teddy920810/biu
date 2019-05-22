package com.abc.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.*;

/**
 * created by CaiBaoHong at 2018/5/25 14:55<br>
 */
@TableName("kd_series")
public class Series extends Model<Series> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String sid;     // 系列id
    private String sname;   // 系列名称
    @TableField("parent_id")
    private String parentId;   // 父级id
    private String desc;     // 描述
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @TableField(exist = false)
    private Series parent = new Series();// 父级

    @Override
    protected Serializable pkVal() {
        return sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() { return sname; }

    public void setSname(String sname) { this.sname = sname; }

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Series getParent() {
        return parent;
    }

    public void setParent(Series parent) {
        this.parent = parent;
    }
}
