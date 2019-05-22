package com.abc.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * created by CaiBaoHong at 2018/5/25 14:55<br>
 */
@TableName("kd_web_config")
public class WebConfig extends Model<WebConfig> {

    @TableId(type = IdType.ID_WORKER_STR)
    private String wid;       // 配置id
    private String wname;   // 企业名称
    private String tel;   // 企业电话
    private String fax;    // 企业传真
    private String email;    // 企业邮箱
    private String ipc;    // IPC备案信息
    private String address;    // 企业地址
    @TableField("address_url")
    private String addressUrl;    // 企业地址地图
    @TableField("wx_qr_code")
    private String wxQRCode;    // 微信公众号二维码图片
    @TableField("wap_qr_code")
    private String wapQRCode;    // 手机网站二维码图片
    private Date created;   // 创建时间
    private Date updated;   // 修改时间

    @Override
    protected Serializable pkVal() { return wid; }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpc() {
        return ipc;
    }

    public void setIpc(String ipc) {
        this.ipc = ipc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressUrl() {
        return addressUrl;
    }

    public void setAddressUrl(String addressUrl) {
        this.addressUrl = addressUrl;
    }

    public String getWxQRCode() {
        return wxQRCode;
    }

    public void setWxQRCode(String wxQRCode) {
        this.wxQRCode = wxQRCode;
    }

    public String getWapQRCode() {
        return wapQRCode;
    }

    public void setWapQRCode(String wapQRCode) {
        this.wapQRCode = wapQRCode;
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
