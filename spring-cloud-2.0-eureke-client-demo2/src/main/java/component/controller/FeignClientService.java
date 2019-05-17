package component.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test1")
public interface FeignClientService {
	@RequestMapping("/getPort")
    public String getPost();
}
