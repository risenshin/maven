package com.iddel.spt.configuration.swagger;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * The class SwaggerDocumentationConfig.
 */
@Configuration
public class SwaggerDocumentationConfig {

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("IDDEL Services")
				.description("Set of APIs that cover the entire lifecycle of IDDEL APP.").license("")
				.licenseUrl("").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "Admin")).build();
	}

	/**
	 * Custom implementation.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.iddel.spt")).build()
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(LocalDateTime.class, java.util.Date.class).apiInfo(apiInfo());
	}

}
