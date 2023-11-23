package com.advanced.poker.domain;

import com.advanced.poker.config.PockerConfig;

public class GameType {

    private Integer cardsPerHand;

    private String type;

    private final static String GAME_TYPE= "com.advance.poker.type";
    private final static String NUMBER_OF_CARDS= "com.advance.pocker.cards.per.hand";

    public GameType() {
        Object gameTypeProperty = PockerConfig.getProperties().get(GAME_TYPE);
        if(gameTypeProperty == null  ){
            throw new RuntimeException("Please configure poker game type");
        }

        this.type = gameTypeProperty.toString();

        Object numberOfCardsProperty = PockerConfig.getProperties().get(NUMBER_OF_CARDS);
        if(numberOfCardsProperty == null  ){
            throw new RuntimeException("Please configure poker number of cards per hand");
        }

        this.cardsPerHand = Integer.valueOf(numberOfCardsProperty.toString());

    }

    public Integer getCardsPerHand() {
        return cardsPerHand;
    }



    public String getType() {
        return type;
    }


}
