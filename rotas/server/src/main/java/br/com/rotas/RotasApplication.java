package br.com.rotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
public class RotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RotasApplication.class, args);
	}

}
