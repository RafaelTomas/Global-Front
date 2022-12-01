package com.globalHealth.globalHealth.config.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMethod;


import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class swaggerConfiguration {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
        .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
        .securityContexts(Arrays.asList(securityContext()));

  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("API Patient - GLOBALHEALTH")
        .description("api feita em java")
        .version("1.0.0")
        .build();
  }

  private List<ResponseMessage> responseMessageForGET() {
    return new ArrayList<ResponseMessage>() {
      {
        add(new ResponseMessageBuilder()
            .code(500)
            .message("500 message")
            .responseModel(new ModelRef("Error"))
            .build());
        add(new ResponseMessageBuilder()
            .code(403)
            .message("Forbidden!")
            .build());
      }
    };
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.ant("/pessoa/**"))
        .build();
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("ADMIN", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(
        new SecurityReference("Token Access", authorizationScopes));
  }

}
