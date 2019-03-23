package com.naga.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

	private RabbitTemplate rabbitTemplate;
	
	@Scheduled(fixedDelay=3000L)
	public void sendMessage() {
		String message= "Test Message-->"+System.currentTimeMillis();
		
		System.err.println("Sending Message.....");
		
		rabbitTemplate.convertAndSend("MyExchange", "TestQueue", message);
		
		System.err.println("Sent Message.....");
	}
}
