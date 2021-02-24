package com.jadson.springproducer.service;

import com.jadson.springproducer.dto.Message;

public interface AmqpService {
	

	void sendToConsumer(Message message);

}
