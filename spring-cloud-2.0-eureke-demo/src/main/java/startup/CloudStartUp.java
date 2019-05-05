package startup;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class CloudStartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList();
		if(args!=null) {
			for(String str:args) {
				strList.add(str);
			}
		}
		
		//strList.add("--spring.config.location=/Users/chencheng/Documents/project/demo/javaDemo/spring-cloud-2.0-eureke-demo/src/main/resources/application-cloud.yml");
		//args = strList.toArray(new String[strList.size()]);
		
		SpringApplication.run(CloudStartUp.class, args);
	}

}
