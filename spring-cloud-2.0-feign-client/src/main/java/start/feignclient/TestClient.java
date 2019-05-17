package start.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zkserv")
public interface TestClient {
	
	@RequestMapping("/getService")
    public String getService();

}
