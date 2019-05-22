package com.abc.controller;

import com.abc.annotation.PermInfo;
import com.abc.constant.PermType;
import com.abc.entity.SysPerm;
import com.abc.entity.SysRole;
import com.abc.entity.SysRolePerm;
import com.abc.entity.WebConfig;
import com.abc.service.*;
import com.abc.vo.Json;
import com.abc.vo.UpdateRolePermVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * created by CaiBaoHong at 2018/5/25 16:41<br>
 */
@PermInfo(value = "网站模块")
@RestController
@RequestMapping("/webConfig")
public class WebConfigController {

    private static final Logger log = LoggerFactory.getLogger(WebConfigController.class);

    @Autowired
    private WebConfigService webConfigService;

    @PostMapping
    public Json add(@RequestBody String body) {

        String oper = "add webConfig";
        WebConfig webConfig = JSON.parseObject(body, WebConfig.class);

        Json x = validateData(webConfig, oper);
        if (x != null) return x;

        WebConfig webConfigDB = webConfigService.selectOne(new EntityWrapper<WebConfig>().eq("wid", webConfig.getWid()));
        if (webConfigDB != null) {
            return Json.fail(oper, "网站配置已存在：" + webConfigDB.getWid());
        }

        //保存新数据
        webConfig.setCreated(new Date());
        boolean success = webConfigService.insert(webConfig);
        return Json.result(oper, success)
                .data("uid",webConfig.getWid())
                .data("created",webConfig.getCreated());
    }


    @PutMapping
    public Json update(@RequestBody String body) {
        String oper = "update webConfig";
        WebConfig webConfig = JSON.parseObject(body, WebConfig.class);

        Json x = validateData(webConfig, oper);
        if (x != null) return x;

        //保存新数据
        webConfig.setUpdated(new Date());
        boolean success = webConfigService.updateById(webConfig);
        return Json.result(oper, success).data("updated", webConfig.getUpdated());
    }

    @GetMapping("/{wid}")
    public Json findById(@PathVariable String wid){
        String oper = "find one";
        log.info("{}, wid: {}", oper, wid);
        if (StringUtils.isBlank(wid)){
            return Json.fail(oper, "无法查询当前数据：参数为空（配置id）");
        }
        WebConfig webConfig = webConfigService.selectById(wid);

        return Json.succ(oper)
                .data("webConfig",webConfig);
    }


    private Json validateData(WebConfig webConfig, String oper) {
        if (StringUtils.isBlank(webConfig.getWname())) {
            return Json.fail(oper, "企业名称不能为空");
        }
        if (StringUtils.isBlank(webConfig.getTel())) {
            return Json.fail(oper, "企业电话不能为空");
        }
        if (StringUtils.isBlank(webConfig.getAddress())) {
            return Json.fail(oper, "企业地址不能为空");
        }
        if (StringUtils.isBlank(webConfig.getIpc())) {
            return Json.fail(oper, "企业IPC不能为空");
        }
        return null;
    }
}
