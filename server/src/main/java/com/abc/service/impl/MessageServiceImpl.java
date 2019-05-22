package com.abc.service.impl;

import com.abc.dao.MessageMapper;
import com.abc.entity.Message;
import com.abc.service.MessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
