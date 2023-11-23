package com.advanced.poker.service;

import com.advanced.poker.domain.FiveCardRankCategory;
import com.advanced.poker.domain.GameRank;

public class GameRankFactory {

    public static GameRank getGameRank(String type){
        if(type.equals("five.card.deal")){
            return new FiveCardRankCategory();
        }

        throw new RuntimeException("Unknown game type "+type);
    }
}
