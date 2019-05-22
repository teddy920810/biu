package com.abc.service.impl;

import com.abc.dao.ProductMapper;
import com.abc.entity.Product;
import com.abc.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
