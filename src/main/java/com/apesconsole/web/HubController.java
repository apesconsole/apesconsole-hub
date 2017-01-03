package com.apesconsole.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apesconsole.entity.SensorData;
import com.apesconsole.repo.SensorLog;

@Controller
public class HubController {
	
	// inject via application.properties
	@Value("${platform.default:LOCAL}")
	private String platform = "LOCAL";
	
	@Autowired
	private SensorLog sensorLog;
	
	@Autowired
	private DirectChannel toMQTT;
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("platform", null != System.getenv("PLATFORM") ? System.getenv("PLATFORM") : this.platform);
		List<SensorData> data = sensorLog.loadSensorData();
		model.put("log_data", data);
		return "index";
	}
	
	@RequestMapping("/pub")
	public String publish(Map<String, Object> model) {
		toMQTT.send(MessageBuilder.withPayload("Test Message").build());
		return home(model);
	}

}
