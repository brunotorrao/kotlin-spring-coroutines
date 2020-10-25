package com.github.brunotorrao.kotlinspringcoroutines.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    
    @Bean
    @Primary
    fun webClient(): WebClient = WebClient.builder().baseUrl("http://localhost:8080").build()
}