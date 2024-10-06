package es.demobet.bets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetsApplication.class, args);
	}

}
