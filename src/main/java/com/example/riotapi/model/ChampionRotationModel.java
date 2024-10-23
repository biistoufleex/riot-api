package com.example.riotapi.model;

import lombok.Data;

@Data
public class ChampionRotationModel {
    private int[] freeChampionIds;
    private int[] freeChampionIdsForNewPlayers;
    private int maxNewPlayerLevel;
}
