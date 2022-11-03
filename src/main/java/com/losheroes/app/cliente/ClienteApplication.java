package com.losheroes.app.cliente;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Cliente API",
				version = "1.0",
				description = "Caja Los Heroes Challenge Middleware - API REST CLIENTE",
				contact = @Contact(name = "Mauricio Ortega", email = "mauriormu@gmail.com")
		)
)

@SuppressWarnings({"unchecked", "deprecated"})
public class  ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
