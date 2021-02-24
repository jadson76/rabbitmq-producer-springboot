package com.jadson.springproducer.amqp;

public interface AmqpProducer<T> {

	void producer(T t);
}
