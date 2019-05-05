package component.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController {
    @Value("server.port")
	private String port;
    
    @RequestMapping("/getPort")
	public String getPost() {
		String str = "服务号端口号: " + port;
		return str;
	}
}
