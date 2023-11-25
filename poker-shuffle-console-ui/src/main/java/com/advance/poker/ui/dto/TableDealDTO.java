package com.advance.poker.ui.dto;

import java.io.Serializable;
import java.util.List;

public class TableDealDTO implements Serializable {
    private List<CardDTO> leftOverCards;

    private List<PlayerHandDTO> playerHands;

    public List<CardDTO> getLeftOverCards() {
        return leftOverCards;
    }

    public void setLeftOverCards(List<CardDTO> leftOverCards) {
        this.leftOverCards = leftOverCards;
    }

    public List<PlayerHandDTO> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(List<PlayerHandDTO> playerHands) {
        this.playerHands = playerHands;
    }

    public static class Builder{
        private List<CardDTO> leftOverCards;

        private List<PlayerHandDTO> playerHands;

        private Builder(){
            super();
        }
        public static Builder forTableDeal(){
            return new Builder();
        }

        public Builder withLeftOverCards(List<CardDTO> leftOverCards){
            this.leftOverCards = leftOverCards;
            return this;
        }
        public Builder withPlayerHands(List<PlayerHandDTO> playerHands){
            this.playerHands = playerHands;
            return this;
        }

        public TableDealDTO build(){
            TableDealDTO tableDealDTO = new TableDealDTO();
            tableDealDTO.setLeftOverCards(this.leftOverCards);
            tableDealDTO.setPlayerHands(this.playerHands);
            return tableDealDTO;
        }
    }
}
