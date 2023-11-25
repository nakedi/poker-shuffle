package com.advance.poker.ui.dto;

import java.io.Serializable;

public class GameTypeDTO implements Serializable {
    private Integer cardsPerHand;

    private String type;

    public Integer getCardsPerHand() {
        return cardsPerHand;
    }

    public void setCardsPerHand(Integer cardsPerHand) {
        this.cardsPerHand = cardsPerHand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder{
        private Integer cardsPerHand;
        private String type;
        private Builder(){
            super();
        }
        public static Builder forGameType(){
            return new Builder();
        }
        public  Builder withCardsPerHand(Integer cardsPerHand){
            this.cardsPerHand = cardsPerHand;
            return this;
        }
        public Builder withType(String type){
            this.type = type;
            return this;
        }
        public GameTypeDTO build(){
            GameTypeDTO gameTypeDTO = new GameTypeDTO();
            gameTypeDTO.setType(this.type);
            gameTypeDTO.setCardsPerHand(this.cardsPerHand);
            return gameTypeDTO;
        }
    }
}
