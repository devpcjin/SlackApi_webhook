package com.example.slackapi.config

import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        val httpRequestFactory = HttpComponentsClientHttpRequestFactory()
        val httpClient = HttpClientBuilder
                .create()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(5)
                .build()

        httpRequestFactory.setConnectTimeout(3000)
        httpRequestFactory.setReadTimeout(5000)
        httpRequestFactory.httpClient = httpClient
        return RestTemplate(httpRequestFactory)
    }
}