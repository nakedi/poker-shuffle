package com.advance.poker.ui.dto;

import java.io.Serializable;
import java.util.List;

public class DeckDTO  implements Serializable {
    private DeckTypeDTO deckType ;
    private List<CardDTO> cards;

    public DeckTypeDTO getDeckType() {
        return deckType;
    }

    public void setDeckType(DeckTypeDTO deckType) {
        this.deckType = deckType;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }

    public static class Builder{
        private DeckTypeDTO deckType ;
        private List<CardDTO> cards;

        private Builder(){
            super();
        }
        public static Builder forDeck(){
            return new Builder();
        }
        public Builder withDeckType(DeckTypeDTO deckTypeDTO){
            this.deckType = deckTypeDTO;
            return this;
        }
        public Builder withCards(List<CardDTO> cards){
            this.cards = cards;
            return this;
        }

        public DeckDTO build(){
            DeckDTO deckDTO = new DeckDTO();
            deckDTO.setCards(this.cards);
            deckDTO.setDeckType(this.deckType);
            return deckDTO;
        }
    }
}
