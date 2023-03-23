package tech.edev404.easybank.configuration.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenApiDocs {

    @Bean
    OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info().title("Easy bank docs").version("1.0.0").description("Easy bank project APIs documentation"));
    }
    
}
