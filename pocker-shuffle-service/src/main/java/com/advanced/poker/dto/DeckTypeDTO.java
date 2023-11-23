package com.advanced.poker.dto;

import java.io.Serializable;

public class DeckTypeDTO implements Serializable {
    private String name;
    private int cardLimit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    public static class Builder{
        private String name;
        private int cardLimit;

        private Builder(){
            super();
        }

        public static Builder forDeclType(){
            return new Builder();
        }

        public Builder withName(String name){
            this.name =name;
            return this;
        }

        public Builder withCardLimit(int cardLimit){
            this.cardLimit =cardLimit;
            return this;
        }

        public DeckTypeDTO build(){
            DeckTypeDTO deckTypeDTO = new DeckTypeDTO();
            deckTypeDTO.setCardLimit(this.cardLimit);
            deckTypeDTO.setName(this.name);
            return deckTypeDTO;
        }
    }
}
