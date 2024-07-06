package weval.dazzi.api.config.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("dazzi API")
                .version("v0.0.1")
                .description("dazzi API");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
