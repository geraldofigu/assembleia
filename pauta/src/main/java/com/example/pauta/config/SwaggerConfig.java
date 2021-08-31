package com.example.pauta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket configuraSwagger() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(informacoesAPI())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.pauta.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo informacoesAPI() {
        return new ApiInfoBuilder()
                .title("Prova Sicredi")
                .description("Execução de BackEnd - Pauta")
                .contact(informacoesContato())
                .build();
    }

    private Contact informacoesContato() {
        return new Contact("Admin", "", "admin@admin.com");
    }
}
