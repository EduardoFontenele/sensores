package br.com.publisher.sensores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PublishersSensoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublishersSensoresApplication.class, args);
	}

}
