package com.ggoom.dreem.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;

@OpenAPIDefinition(
        info = @Info(title = "Dreeeeeeeem API Document", version = "v0.0.0"),
        security = {
                @SecurityRequirement(name = "SecretKey Authentication")
        }
)
@SecurityScheme(
        name = "SecretKey Authentication",
        type = HTTP,
        scheme = "Bearer",
        description = "Secret Key를 Authorization header에 추가해야 합니다."
)
@Configuration
class SwaggerConfig {
}
