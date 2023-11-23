package com.advanced.poker.domain;

import java.util.List;

public class TableDeal {

    private List<Card> leftOverCards;

    private List<PlayerHand> playerHands;

    public List<Card> getLeftOverCards() {
        return leftOverCards;
    }

    public void setLeftOverCards(List<Card> leftOverCards) {
        this.leftOverCards = leftOverCards;
    }

    public List<PlayerHand> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(List<PlayerHand> playerHands) {
        this.playerHands = playerHands;
    }
}
