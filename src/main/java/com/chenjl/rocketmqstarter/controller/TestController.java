package com.chenjl.rocketmqstarter.controller;

import cn.hutool.core.lang.UUID;
import com.chenjl.rocketmqstarter.dto.TestMessageDto;
import com.chenjl.rocketmqstarter.resource.RocketMQSource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjunl
 * @description
 * @date 2023/2/3
 */
@RestController
public class TestController {


    @Autowired
    private RocketMQSource rocketMQSource;

    /**
     * 发送消息
     *
     * @return
     */
    @GetMapping(value = "test/send")
    public boolean sendMessage() {
        TestMessageDto testMessageDto = new TestMessageDto();
        testMessageDto.setAge(1);
        testMessageDto.setName("abc");
        Message message = MessageBuilder.withPayload(testMessageDto)
                .setHeader(MessageConst.PROPERTY_TAGS, "resource_test")
                .setHeader(MessageConst.PROPERTY_KEYS, "test_" + UUID.fastUUID().toString())
                .setHeader("METHOD", "ADD")
                .build();
        return rocketMQSource.sender().send(message);
    }


}
