package com.jadson.springproducer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadson.springproducer.amqp.AmqpProducer;
import com.jadson.springproducer.dto.Message;
import com.jadson.springproducer.service.AmqpService;

@Service
public class RabbitService implements AmqpService{
	
	@Autowired
	private AmqpProducer<Message> amqp;

	
	@Override
	public void sendToConsumer(Message message) {
		amqp.producer(message);
		
	}	

}
