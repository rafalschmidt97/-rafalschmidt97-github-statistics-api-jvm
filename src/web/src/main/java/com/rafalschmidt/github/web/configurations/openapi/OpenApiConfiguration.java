package com.rafalschmidt.github.web.configurations.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 class OpenApiConfiguration {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(getApiInfo())
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.rafalschmidt.github.web.controllers"))
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
      .title("Github Statistics")
      .description("Implementation of Allegro' recruitment task")
      .contact(new Contact("Rafał Schmidt", "https://rafalschmidt.com", "rafalschmidt97@gmail.com"))
      .version("1.0.0")
      .build();
  }
}
