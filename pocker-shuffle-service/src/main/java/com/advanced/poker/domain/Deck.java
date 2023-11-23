package com.advanced.poker.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public record Deck (DeckType deckType, List<Card> cards) implements Serializable {

    public Deck{
        Objects.requireNonNull(deckType);
        Objects.requireNonNull(cards);

        if(cards.size() > deckType.cardLimit()){
            throw new IllegalArgumentException("Deck Type \""+deckType.name()+"\" has a limit of "+ deckType.cardLimit()
            +". However card list of size "+cards.size()+" ws added");
        }
    }
}
