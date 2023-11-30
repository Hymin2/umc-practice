package com.umc.project.global.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "UMC Server WorkBook API",
                description = "UMC Server WorkBook API 명세서",
                version = "v1"))
public class SwaggerConfig {

}
