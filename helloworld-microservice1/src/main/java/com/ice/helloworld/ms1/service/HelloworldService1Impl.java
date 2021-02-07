package com.ice.helloworld.ms1.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ice.helloworld.ms1.feign.service.HelloworldFeignService2;

@Service
public class HelloworldService1Impl implements HelloworldService1 {
	
	private Logger logger = Logger.getLogger(HelloworldService1Impl.class.getName());

	@Autowired
	private HelloworldFeignService2 helloworldFeignService2;

	@Override
	public String callService2(String name) {
		logger.info("Service1 calling Service2.....");
		return helloworldFeignService2.callService2(name);
	}
}
