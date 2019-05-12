package component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestServiceController {
    @Value("${server.port}")
	private String port;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("/getPort")
    public String getPost() {
		String str = "服务号端口号: " + port;
		return str;
	}
	
    @RequestMapping("/testPort")
    public String testPost() {
    	   String url = "http://test1/getPort";
       String postStr = restTemplate.getForObject(url,String.class);
       return postStr;
    }
    
}
