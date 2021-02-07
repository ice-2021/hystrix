package com.ice.helloworld.ms1.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ice.helloworld.ms1.service.HelloworldService1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloWorldController {

	private Logger logger = Logger.getLogger(HelloWorldController.class.getName());

	@Autowired
	private HelloworldService1 helloworldService1;

	@GetMapping("/helloworld1/service1")
	@HystrixCommand(fallbackMethod = "fallbackService2")
	public ResponseEntity<String> getGreeting(@RequestParam("name") String name) {
		return new ResponseEntity<String>(helloworldService1.callService2(name), HttpStatus.OK);
	}

	public ResponseEntity<String> fallbackService2(String name) {
		return new ResponseEntity<String>("Service2 Down. Fallback called..", HttpStatus.OK);
	}

}
