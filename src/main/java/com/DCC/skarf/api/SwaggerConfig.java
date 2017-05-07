package com.DCC.skarf.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Sample REST API", "Prototype API for DCC Project", "API TOS", "Terms of service",
				"nikolai@luis.is", "License of API", "not yet");
		return apiInfo;
	}
}