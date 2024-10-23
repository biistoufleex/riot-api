package com.example.riotapi.model;

import lombok.Data;

@Data
public class SummonerModel {
    private String id;
    private String accountId;
    private String puuid;
    private int profileIconId;
    private long revisionDate;
    private long summonerLevel;
}
