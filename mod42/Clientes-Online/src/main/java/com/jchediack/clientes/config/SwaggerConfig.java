package com.jchediack.clientes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Clientes API")
                            .version("1.0")
                            .description("API para gerenciamento de clientes")
                            .contact(new Contact()
                                    .name("Jorge Chediack")
                                    .email("jorge@exemplo.com")
                                    .url("https://www.exemplo.com")));
        }

}

