package application.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public String test() {
		int i = 15;
		return "num="+i*21; 
	}
	
	@RequestMapping("/test2")
	public String test2() {
		int i = 10;
		return "num="+i*21; 
	}
	
	
}
