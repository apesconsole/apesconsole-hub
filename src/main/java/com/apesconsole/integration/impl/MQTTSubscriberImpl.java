package com.apesconsole.integration.impl;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import com.apesconsole.integration.MQTTSubscriber;

public class MQTTSubscriberImpl implements MQTTSubscriber {

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println("Received Message !!");
		System.out.println(message.getPayload());
	}
}
