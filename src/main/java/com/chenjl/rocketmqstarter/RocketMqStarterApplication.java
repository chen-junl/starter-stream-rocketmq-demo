package com.chenjl.rocketmqstarter;

import com.chenjl.rocketmqstarter.resource.RocketMQSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({RocketMQSource.class})
public class RocketMqStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMqStarterApplication.class, args);
    }

}
