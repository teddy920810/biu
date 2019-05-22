package com.abc.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * created by CaiBaoHong at 2018/5/25 14:55<br>
 */
@TableName("kd_message")
public class Message extends Model<Message> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String mid;       // 留言id
    private String customer;   // 留言顾客姓名
    private String phone;   // 留言电话
    private String email;    // 留言邮箱
    private String content;    // 留言内容
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @Override
    protected Serializable pkVal() { return mid; }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
