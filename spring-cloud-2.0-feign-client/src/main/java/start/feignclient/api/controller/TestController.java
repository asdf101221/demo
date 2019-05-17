package start.feignclient.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import start.feignclient.TestClient;

@RestController
public class TestController {
	
	@Autowired
	TestClient testClient;
	
	@RequestMapping("/testService")
	public String TestService() {
		System.out.println("testService");
		return testClient.getService();
	}
}
