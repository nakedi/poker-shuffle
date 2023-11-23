package com.advanced.poker.dto;

import com.advanced.poker.domain.HandStrength;

import java.io.Serializable;
import java.util.List;

public class PlayerHandDTO  implements Serializable {

    private HandStrengthDTO handStrength;
    private List<CardDTO> cards;

    public HandStrengthDTO getHandStrength() {
        return handStrength;
    }

    public void setHandStrength(HandStrengthDTO handStrength) {
        this.handStrength = handStrength;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }

    public static class Builder{
        private HandStrengthDTO handStrength;
        private List<CardDTO> cards;

        private Builder(){
            super();
        }
        public static Builder forPlayerHand(){
            return new Builder();
        }
        public Builder withHandStrength(HandStrengthDTO handStrength){
            this.handStrength = handStrength;
            return this;
        }
        public Builder withCards(List<CardDTO> cards){
            this.cards = cards;
            return this;
        }
        public PlayerHandDTO build(){
            PlayerHandDTO playerHandDTO = new PlayerHandDTO();
            playerHandDTO.setCards(this.cards);
            playerHandDTO.setHandStrength(this.handStrength);

            return playerHandDTO;
        }

    }
}
