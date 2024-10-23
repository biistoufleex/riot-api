package com.example.riotapi.controller;

import com.example.riotapi.model.AccountModel;
import com.example.riotapi.model.ChampionRotationModel;
import com.example.riotapi.model.SummonerModel;
import com.example.riotapi.service.impl.RiotApiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RiotApiController {
    private final RiotApiServiceImpl riotApiService;

    @GetMapping("/champion-rotation")
    public ChampionRotationModel getChampionRotation() throws Exception {
        return riotApiService.getChampionRotation();
    }

    @GetMapping("/account/riot-id/{summonerName}/{tagLine}")
    public AccountModel getBySummonerName(@PathVariable String summonerName, @PathVariable String tagLine) throws Exception {
        return riotApiService.getBySummonerName(summonerName, tagLine);
    }

    @GetMapping("/account/by-riot-id/{puuid}")
    public SummonerModel getSummonerByPuuid(@PathVariable String puuid) throws Exception {
        return riotApiService.getSummonerByPuuid(puuid);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
