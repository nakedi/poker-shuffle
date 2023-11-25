package com.advanced.poker.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public abstract class GameRank {

    public abstract Map<TreeSet<CardIDEnum>, HandStrength>  getRankCategoryByHand();

    public TreeSet<CardIDEnum> getCardIdList(List<Card> cards){
        TreeSet<CardIDEnum> cardIDEnums = new TreeSet<>();
        for (Card card:cards) {
            cardIDEnums.add(card.getId());
        }
        return cardIDEnums;
    }
}
