package com.example.riotapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiotApiConfig {
    private final RiotApiProperties properties;

    public RiotApiConfig(RiotApiProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RiotApiUrls riotApiUrls() {
        return new RiotApiUrls(
                properties.getKey(),
                properties.buildUrl(properties.getRegions().getEuw1()),
                properties.buildUrl(properties.getRegions().getEurope()),
                properties.buildUrl(properties.getRegions().getEun1())
        );
    }
}