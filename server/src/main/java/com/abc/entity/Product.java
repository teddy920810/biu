package com.abc.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by CaiBaoHong at 2018/5/25 14:55<br>
 */
@TableName("kd_product")
public class Product extends Model<Product> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String pid;       // 产品id
    private String pname;   // 产品名称
    @TableField("top_img_url")
    private String topImgUrl;   // 产品列表页图片url
    @TableField("scan_qr_code")
    private String scanQRCode;   // 产品扫码购二维码
    private String details;   // 产品详情富文本
    @TableField("series_id")
    private String seriesId; // 所属系列id
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @TableField(exist = false)
    private List<String> imgUrls = new ArrayList<>();   // 产品详情页图片集
    @TableField(exist = false)
    private List<String> feature = new ArrayList<>();
    @TableField(exist = false)
    private Series series = new Series();// 所属系列

    @Override
    protected Serializable pkVal() { return pid; }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTopImgUrl() {
        return topImgUrl;
    }

    public void setTopImgUrl(String topImgUrl) {
        this.topImgUrl = topImgUrl;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public String getScanQRCode() {
        return scanQRCode;
    }

    public void setScanQRCode(String scanQRCode) {
        this.scanQRCode = scanQRCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
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
