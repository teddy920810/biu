package com.abc.service.impl;

import com.abc.dao.SeriesMapper;
import com.abc.entity.Series;
import com.abc.service.SeriesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SeriesServiceImpl extends ServiceImpl<SeriesMapper, Series> implements SeriesService {
}
