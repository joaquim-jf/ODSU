package com.joaquimFelix.ODSU;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "OdsuAPI", version = "1", description = "Sistema de Ordem de Serviço Automotivo,"))
public class OdsuApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdsuApplication.class, args);
	}

}
