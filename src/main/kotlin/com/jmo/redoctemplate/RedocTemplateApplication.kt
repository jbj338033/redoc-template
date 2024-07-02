package com.jmo.redoctemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class RedocTemplateApplication

fun main(args: Array<String>) {
    runApplication<RedocTemplateApplication>(*args)
}
