package com.zinkworks.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotación de Spring Boot para indicar que esta es una aplicación Spring Boot y habilitar la configuración automática
public class PetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args); // Método principal para ejecutar la aplicación Spring Boot
	}

}
