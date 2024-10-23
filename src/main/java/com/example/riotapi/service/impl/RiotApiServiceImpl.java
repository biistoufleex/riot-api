package com.example.riotapi.service.impl;

import com.example.riotapi.configuration.RiotApiUrls;
import com.example.riotapi.model.AccountModel;
import com.example.riotapi.model.ChampionRotationModel;
import com.example.riotapi.model.SummonerModel;
import com.example.riotapi.service.RiotApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class RiotApiServiceImpl implements RiotApiService {

    private final RiotApiUrls urls;

    private WebClient riotApiClient(String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Riot-Token", urls.apiKey())
                .build();
    }

    @Override
    public ChampionRotationModel getChampionRotation() {
        String url = "lol/platform/v3/champion-rotations";
        return getDataFromClient(urls.baseUrlEuw1(), url, ChampionRotationModel.class);
    }

    @Override
    public AccountModel getBySummonerName(String summonerName, String tagLine) {
        String url = String.format("riot/account/v1/accounts/by-riot-id/%s/%s", summonerName, tagLine);
        return getDataFromClient(urls.baseUrlEurope(), url, AccountModel.class);
    }

    @Override
    public SummonerModel getSummonerByPuuid(String puuid) {
        String url = String.format("lol/summoner/v4/summoners/by-puuid/%s", puuid);
        return getDataFromClient(urls.baseUrlEun1(), url, SummonerModel.class);
    }

    private <T> T getDataFromClient(String baseUrl, String url, Class<T> modelClass) {
        return riotApiClient(baseUrl)
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(modelClass)
                .block();
    }
}
