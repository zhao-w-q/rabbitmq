package com.dfbz.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zhao
 * @description
 * @date 2019/12/18
 */
@Component
@RabbitListener(queues = "xiaofang")
public class Consumer4 {

    @RabbitHandler
    public void receiveMsg(String msg) {
        System.out.println("xiaofang接收到的消息：" + msg);
    }
}
