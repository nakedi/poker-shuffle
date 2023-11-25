package com.advanced.poker.domain;

import com.advanced.poker.config.PockerConfig;

public class GameType {

    private Integer cardsPerHand;

    private String type;

    public GameType(Integer cardsPerHand, String type) {
        this.cardsPerHand = cardsPerHand;
        this.type = type;
    }

    public Integer getCardsPerHand() {
        return cardsPerHand;
    }



    public String getType() {
        return type;
    }


}
