package com.abc.service.impl;

import com.abc.dao.AdverMapper;
import com.abc.entity.Adver;
import com.abc.service.AdverService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdverServiceImpl extends ServiceImpl<AdverMapper, Adver> implements AdverService {
}
