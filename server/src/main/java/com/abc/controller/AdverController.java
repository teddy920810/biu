package com.abc.controller;

import com.abc.annotation.PermInfo;
import com.abc.entity.Adver;
import com.abc.entity.WebConfig;
import com.abc.service.AdverService;
import com.abc.service.WebConfigService;
import com.abc.vo.Json;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * created by CaiBaoHong at 2018/5/25 16:41<br>
 */
@PermInfo(value = "广告模块")
@RestController
@RequestMapping("/adver")
public class AdverController {

    private static final Logger log = LoggerFactory.getLogger(AdverController.class);

    @Autowired
    private AdverService adverService;

    @PostMapping
    public Json add(@RequestBody String body) {

        String oper = "add adver";
        Adver adver = JSON.parseObject(body, Adver.class);

        Json x = validateData(adver, oper);
        if (x != null) return x;

        if(adver.getType().equals("img")){
            Adver adverDB = adverService.selectOne(new EntityWrapper<Adver>().eq("key", adver.getKey()));
            if (adverDB != null) {
                return Json.fail(oper, "已存在：" + adverDB.getAid());
            }
        }

        //保存新数据
        adver.setCreated(new Date());
        boolean success = adverService.insert(adver);
        return Json.result(oper, success)
                .data("aid",adver.getAid())
                .data("created",adver.getCreated());
    }


    @PutMapping
    public Json update(@RequestBody String body) {
        String oper = "update adver";
        Adver adver = JSON.parseObject(body, Adver.class);

        Json x = validateData(adver, oper);
        if (x != null) return x;

        //保存新数据
        adver.setUpdated(new Date());
        boolean success = adverService.updateById(adver);
        return Json.result(oper, success).data("updated", adver.getUpdated());
    }

    @GetMapping("/{key}")
    public Json findById(@PathVariable String key){
        String oper = "find by key";
        log.info("{}, wid: {}", oper, key);
        if (StringUtils.isBlank(key)){
            return Json.fail(oper, "无法查询当前数据：参数为空（广告标识id）");
        }
        List<Adver> adverList = adverService.selectList(new EntityWrapper<Adver>().eq("key", key));

        return Json.succ(oper)
                .data("adverList",adverList);
    }

    private Json validateData(Adver adver, String oper) {
        if (StringUtils.isBlank(adver.getImg())) {
            return Json.fail(oper, "图片不能为空");
        }
        if (StringUtils.isBlank(adver.getType())) {
            return Json.fail(oper, "类型不能为空");
        }
        if (StringUtils.isBlank(adver.getKey().getCode())) {
            return Json.fail(oper, "标识不能为空");
        }
        return null;
    }
}
