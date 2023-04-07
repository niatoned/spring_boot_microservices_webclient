package com.emonics.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.emonics.beans.HelloObject;

@Controller
public class HelloWebClientController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/")
	public String helloRequest(Model model) {
		List<ServiceInstance> instances = discoveryClient.getInstances("micro-service");
		
		if(instances != null && instances.size() > 0) {
			ServiceInstance serviceInstance = instances.get(0);
			String url = serviceInstance.getUri().toString();
			url += "/hello";
			
			
			RestTemplate restTemplate = new RestTemplate();
			HelloObject helloObject = restTemplate.getForObject(url, HelloObject.class);
			
			model.addAttribute("msg", helloObject.getMessage());
			model.addAttribute("time", LocalDateTime.now());
		}
		
		return "hello-page";
	}
}
