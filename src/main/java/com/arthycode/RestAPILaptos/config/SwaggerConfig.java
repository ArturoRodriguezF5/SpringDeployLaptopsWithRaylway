package com.arthycode.RestAPILaptos.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Spring Boot API REST Laptops")
                        .description("Application for Laptops wiht Spring Boot")
                        .version("v1.0")
                        .license(new License().name("MIT").url("http://opensource.org/licenses/")))
                .externalDocs(new ExternalDocumentation().description("Documentation")
                        .url("http://opensource.org/licenses"));
    }
}
