package com.example.riotapi.service;

import com.example.riotapi.model.AccountModel;
import com.example.riotapi.model.ChampionRotationModel;
import com.example.riotapi.model.SummonerModel;

public interface RiotApiService {
    ChampionRotationModel getChampionRotation();
    AccountModel getBySummonerName(String summonerName, String tagLine);
    SummonerModel getSummonerByPuuid(String puuid);
}