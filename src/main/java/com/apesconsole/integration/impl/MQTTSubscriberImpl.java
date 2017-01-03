package com.apesconsole.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import com.apesconsole.entity.SensorData;
import com.apesconsole.integration.MQTTSubscriber;
import com.apesconsole.repo.SensorLog;

public class MQTTSubscriberImpl implements MQTTSubscriber {
	
	@Autowired
	private SensorLog sensorLog;
	
	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		SensorData data = new SensorData();
		data.setMessage(message.getPayload().toString());
		sensorLog.logSensorData(data);
	}
}
