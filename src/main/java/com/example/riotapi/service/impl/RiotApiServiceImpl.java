package com.example.riotapi.service.impl;

import com.example.riotapi.configuration.RiotApiUrls;
import com.example.riotapi.model.AccountModel;
import com.example.riotapi.model.ChampionRotationModel;
import com.example.riotapi.model.SummonerModel;
import com.example.riotapi.service.RiotApiService;
import com.example.riotapi.utils.RiotApiClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class RiotApiServiceImpl implements RiotApiService {

    private final RiotApiUrls urls;
    private final RiotApiClientUtil riotApiClientUtil;

    @Override
    public ChampionRotationModel getChampionRotation() {
        String url = "lol/platform/v3/champion-rotations";
        return riotApiClientUtil.getDataFromClient(urls.baseUrlEuw1(), urls.apiKey(), url, ChampionRotationModel.class);
    }

    @Override
    public AccountModel getBySummonerName(String summonerName, String tagLine) {
        String url = String.format("riot/account/v1/accounts/by-riot-id/%s/%s", summonerName, tagLine);
        return riotApiClientUtil.getDataFromClient(urls.baseUrlEurope(), urls.apiKey(), url, AccountModel.class);
    }

    @Override
    public SummonerModel getSummonerByPuuid(String puuid) {
        String url = String.format("lol/summoner/v4/summoners/by-puuid/%s", puuid);
        return riotApiClientUtil.getDataFromClient(urls.baseUrlEun1(), urls.apiKey(), url, SummonerModel.class);
    }


}
