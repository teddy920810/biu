package com.abc.service.impl;

import com.abc.dao.WebConfigMapper;
import com.abc.entity.WebConfig;
import com.abc.service.WebConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WebConfigServiceImpl extends ServiceImpl<WebConfigMapper, WebConfig> implements WebConfigService {
}
