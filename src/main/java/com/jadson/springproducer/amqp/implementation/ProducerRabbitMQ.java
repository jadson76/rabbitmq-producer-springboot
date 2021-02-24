package com.jadson.springproducer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jadson.springproducer.amqp.AmqpProducer;
import com.jadson.springproducer.dto.Message;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message>{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;  
	
	@Value("${spring.rabbitmq.request.exchenge.producer}")
	private String exchange;
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;

	@Override
	public void producer(Message message) {
		try {
			rabbitTemplate.convertAndSend(exchange,queue,message);
		}catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
		
		
	}

}
