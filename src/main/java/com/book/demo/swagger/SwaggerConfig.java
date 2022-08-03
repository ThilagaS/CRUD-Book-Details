package com.book.demo.swagger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/5/17
 * Time: 7:53 AM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));

    @Bean
    
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
             
                .directModelSubstitute(LocalDate.class, Date.class)
      
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.book.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .apiInfo(apiDetails())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("Book Application")
                .termsOfServiceUrl("Free to use")
                .version("1.0")
                //.contact(new Contact("XXX", "http://wwww.example.com", "test@example.com"))
                .license("API License")
               // .licenseUrl("http://wwww.example.com")
                .build();
    }
}
