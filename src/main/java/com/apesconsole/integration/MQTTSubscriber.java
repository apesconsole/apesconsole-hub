package com.apesconsole.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

public interface MQTTSubscriber {
	public void handleMessage(Message<?> message) throws MessagingException;
}
