package com.ndirangu.easysoftware.config;

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
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ndirangu.easysoftware.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo(){
        return new ApiInfoBuilder().title("Easy Software API")
                .description("Endpoints for Easy Software")
                .contact(new Contact("David Muchai","https://www.davidmuchai.com/", "ndirangu.muchai@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
