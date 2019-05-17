package startup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperServiceClient {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
    private String serverPort;
	
	 @RequestMapping("/getService")
	    public String getService() {
	      	List<String> serviceList = discoveryClient.getServices();
	      	List<ServiceInstance> serviceInstance = null;
	      	StringBuffer strBf = new StringBuffer();
	      	strBf.append("<br>");
	      	for(String str:serviceList) {
	      		strBf.append(str);
	      		strBf.append("<br>");
	      		serviceInstance = discoveryClient.getInstances(str);
	      		for(ServiceInstance si:serviceInstance) {
	      			strBf.append("&nbsp;&nbsp;"+si.getUri());
	      			strBf.append("<br>");
	      		}
	      		strBf.append("<br>");
	      	}
	        return "服务列表:" + strBf.toString();
	    }
    @RequestMapping("/getMember")
    public String getMember() {
      	
        return "订单服务调用接口,端口号为:" + serverPort;
    }
    
    @RequestMapping("/orderToMember")
    public String orderToMember() {
        String memberUrl = "http://zkserv/getMember";
        return restTemplate.getForObject(memberUrl, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServiceClient.class, args);
    }
    
 // 默认rest方式开启 负载均衡功能
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    
}
