package com.example.riotapi.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RiotApiClientUtil {
    private WebClient riotApiClient(String baseUrl, String apiKey) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Riot-Token", apiKey)
                .build();
    }

    public  <T> T getDataFromClient(String baseUrl,String apiKey, String url, Class<T> modelClass) {
        return riotApiClient(baseUrl, apiKey)
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(modelClass)
                .block();
    }
}
