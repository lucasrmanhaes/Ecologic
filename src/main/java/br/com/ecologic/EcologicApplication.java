package br.com.ecologic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcologicApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcologicApplication.class, args);
	}

}
