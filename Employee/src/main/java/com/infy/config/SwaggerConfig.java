package com.infy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket employeeApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.any())
        		.apis(RequestHandlerSelectors.basePackage("com.infy"))
                .build()
                .apiInfo(metaData());
    }

	private ApiInfo metaData() {
		 return new ApiInfo(
			      "Employee Details API", 
			      "Some custom description of API.", 
			      "API TOS", 
			      "Terms of service", 
			      new Contact("Shivam Choubey", "www.example.com", "shivam@gmail.com"), 
			      "License of API", "API license URL");
	}

}
