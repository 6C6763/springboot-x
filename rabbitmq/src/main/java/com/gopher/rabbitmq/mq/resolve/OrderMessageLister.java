package com.gopher.rabbitmq.mq.resolve;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
/**
 * @author 6c6763
 * @date 2020/10/30
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("order-q"))
public class OrderMessageLister {

    @RabbitListener
    public void receive(String message) {
        System.out.println("message= " + message);
    }

    /**
     * 	组合使用监听
     * 	@RabbitListener @QueueBinding @Queue @Exchange
     * @param message
     * @param channel
     * @throws Exception
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-q", durable = "true"),
            exchange = @Exchange(name = "e-order",
                    type = "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    )
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        //	1. 收到消息以后进行业务端消费处理
        System.err.println("-----------------------");
        System.err.println("消费消息:" + message.getPayload());

        //  2. 处理成功之后 获取deliveryTag 并进行手工的ACK操作, 因为我们配置文件里配置的是 手工签收
        //	spring.rabbitmq.listener.simple.acknowledge-mode=manual
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
