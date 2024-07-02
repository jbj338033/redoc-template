package com.jmo.redoctemplate.global.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun api(): OpenAPI = OpenAPI()
        .info(Info().title("Redoc Template API").description("Redoc Template API 명세서").version("v1"))
}