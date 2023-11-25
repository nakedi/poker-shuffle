package com.advanced.poker.dto;

import java.io.Serializable;

public class PokerGameDTO implements Serializable {

    private DeckDTO deck;
    private TableDealDTO tabelDeal;
    private GameTypeDTO gameType;
    private ErrorDTO errorDTO;
    public DeckDTO getDeck() {
        return deck;
    }

    public void setDeck(DeckDTO deck) {
        this.deck = deck;
    }

    public TableDealDTO getTabelDeal() {
        return tabelDeal;
    }

    public void setTabelDeal(TableDealDTO tabelDeal) {
        this.tabelDeal = tabelDeal;
    }

    public GameTypeDTO getGameType() {
        return gameType;
    }

    public void setGameType(GameTypeDTO gameTypeDTO) {
        this.gameType = gameTypeDTO;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

    public static class Builder{
        private DeckDTO deck;
        private TableDealDTO tableDeal;
        private GameTypeDTO gameTypeDTO;
        private ErrorDTO errorDTO;

        private Builder(){
            super();
        }
        public static Builder forPokerGame(){
            return new Builder();
        }
        public Builder withDeck(DeckDTO deck){
            this.deck =deck;
            return this;
        }
        public Builder withTableDeal(TableDealDTO tableDeal){
            this.tableDeal = tableDeal;
            return this;
        }

        public Builder withGameType(GameTypeDTO gameType){
            this.gameTypeDTO = gameType;
            return this;
        }
        public Builder withError(ErrorDTO errorDTO){
            this.errorDTO = errorDTO;
            return this;
        }
        public PokerGameDTO build(){
            PokerGameDTO pokerGameDTO = new PokerGameDTO();
            pokerGameDTO.setDeck(this.deck);
            pokerGameDTO.setTabelDeal(this.tableDeal);
            pokerGameDTO.setGameType(this.gameTypeDTO);
            pokerGameDTO.setErrorDTO(this.errorDTO);
            return pokerGameDTO;
        }
    }
}
