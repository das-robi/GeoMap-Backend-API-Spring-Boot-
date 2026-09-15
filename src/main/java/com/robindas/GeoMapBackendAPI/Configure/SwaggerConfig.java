package com.robindas.GeoMapBackendAPI.Configure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("GeoMap")
                        .description("Spring boot backend Restful Api Doc")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Robin Das")
                                .email("contac.robindas@gmail.com")));
    }

}
