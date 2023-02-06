package com.chenjl.rocketmqstarter.listener;

import cn.hutool.json.JSONUtil;
import com.chenjl.rocketmqstarter.dto.TestMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 消息接收
 */
@Service
@Slf4j
public class RocketMQListener {


    @StreamListener(value = "subscribe", condition = "headers['ROCKET_TAGS']=='resource_test'")
    public void resourceArticleChangeSubscribe(@Payload TestMessageDto model,
                                               @Headers Map<String, Object> headers,
                                               @Header(name = "METHOD") String method,
                                               @Header(name = "rocketmq_MESSAGE_ID", required = false) String messageId) throws InterruptedException {
        log.info("接收到消息,消息id:{},请求头:{},消息内容:{}", messageId, JSONUtil.toJsonStr(headers), JSONUtil.toJsonStr(model));
        Thread.sleep(100);
        log.info("处理消息完毕,消息id:{}", messageId);
    }
}
