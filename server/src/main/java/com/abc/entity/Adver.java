package com.abc.entity;

import com.abc.enums.AdverEnum;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * created by CaiBaoHong at 2018/5/25 14:55<br>
 */
@TableName("kd_adver")
public class Adver extends Model<Adver> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String aid;       // 广告id
    private String img;   // 广告图片url
    private String url;   // 广告跳转url
    private String type;    // 广告类型（单图img、多图slide）
    private AdverEnum key;    // 广告位标识 -- 枚举
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @Override
    protected Serializable pkVal() { return aid; }

    public String getAid() { return aid; }

    public void setAid(String aid) { this.aid = aid; }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AdverEnum getKey() {
        return key;
    }

    public void setKey(AdverEnum key) {
        this.key = key;
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
