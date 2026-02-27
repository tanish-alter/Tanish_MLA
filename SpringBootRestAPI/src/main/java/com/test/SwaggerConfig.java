package com.test;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {
	
	@Bean
	public OpenAPI apiInfo() {
		
		return new OpenAPI().info(new Info().title("GMST API")
				.description("CRUD OPERATIONS")
				.version("1.0.0"));
	}
}
