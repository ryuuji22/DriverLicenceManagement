package com.mitocode.licensewriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class LicenseWriteServiceApplication {
	
	private final ApplicationContext applicationContext;

	public LicenseWriteServiceApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	@Bean
	public Registry registry() {
		return new SpringRegistry(applicationContext);
	}

	@Bean
	public Mediator mediator(Registry registry) {
		return new SpringMediator(registry);
	}
	
	@Bean
	public OpenAPI springLicenseOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("License API")
	              .description("License Management API")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0")
	              .url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"));
	}
	
	@PostConstruct
	void setGlobalSecurityContext() {
	  SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	public static void main(String[] args) {
		SpringApplication.run(LicenseWriteServiceApplication.class, args);
	}

}
