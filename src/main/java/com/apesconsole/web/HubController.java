package com.apesconsole.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController {
	
	// inject via application.properties
	@Value("${platform.default:LOCAL}")
	private String platform = "LOCAL";
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("platform", null != System.getenv("PLATFORM") ? System.getenv("PLATFORM") : this.platform);
		return "index";
	}
}
