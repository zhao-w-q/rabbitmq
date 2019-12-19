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
@RabbitListener(queues = "xiaozhun")
public class Consumer2 {

    @RabbitHandler
    public void receiveMsg(String msg) {
        System.out.println("xiaozhun接收到的消息：" + msg);
    }
}
