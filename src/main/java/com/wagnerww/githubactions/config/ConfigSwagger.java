package com.wagnerww.githubactions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// EXEMPLO SWAGGER
public class ConfigSwagger {

  @Value("/")
  private String pathMapping;

  @Bean
  public Docket simpleDiffServiceApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("GitHub-Actions-Example").apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/**")).build().pathMapping(pathMapping);

  }

  @Bean
  public SecurityConfiguration security() {
    return SecurityConfigurationBuilder.builder().clientId(null).clientSecret(null).realm(null).appName(null)
        .scopeSeparator("").build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("GitHub-Actions-Example").build();
  }

}
