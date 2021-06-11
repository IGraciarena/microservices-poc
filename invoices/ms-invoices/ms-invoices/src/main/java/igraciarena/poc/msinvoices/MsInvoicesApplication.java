package igraciarena.poc.msinvoices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsInvoicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInvoicesApplication.class, args);
	}

}
