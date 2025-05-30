package com.delphinton.microservices.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Product Service APi")
                        .description("This is the REST API for Product Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                        .externalDocs(new ExternalDocumentation()
                                .description("This is the REST API for Product Service. You refer to Wiki doc")
                                .url("https://product-service-dummy-url.com/docs"));
    }
}
