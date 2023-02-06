package com.chenjl.rocketmqstarter.resource;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


/**
 * 消息
 */
public interface RocketMQSource {
    /**
     * 发送消息
     *
     * @return
     */
    @Output("sender")
    MessageChannel sender();

    /**
     * 接收消息
     *
     * @return
     */
    @Input("subscribe")
    SubscribableChannel subscribe();
}
