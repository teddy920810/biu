package com.abc.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

public enum AdverEnum implements IEnum{

    INDEX_BANNER("INDEX_BANNER", "首页顶部广告"),
    INDEX_BANNER2("INDEX_BANNER2", "首页顶部广告"),
    INDEX_BANNER3("INDEX_BANNER3", "首页顶部广告"),;

    AdverEnum(String code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    private final String code;
    private final String descp;

    public String getCode() {
        return code;
    }

    public String getDescp() {
        return descp;
    }

    @Override
    public Serializable getValue() {
        return this.code;
    }
}
