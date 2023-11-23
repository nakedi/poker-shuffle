package com.advanced.poker.service;

import com.advanced.poker.config.PockerConfig;
import com.advanced.poker.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Service
public class DealService {

    private GameType gameType = new GameType();

    public TableDeal deal(List<Card> cards,int numberOfPlayers){

        List<PlayerHand> playerHands = new ArrayList<>();
        GameRank gameRank = GameRankFactory.getGameRank(gameType.getType());

        List<Card> leftOverCards = new ArrayList<>(
                Arrays.asList(
                        Arrays.copyOf(
                                cards.toArray(new Card[cards.size()]),cards.size())));

        for(int index = 0; index < numberOfPlayers; index++) {
            List<Card> cardsOnHandList = new ArrayList<>();
            for(int cardCount =0; cardCount < gameType.getCardsPerHand(); cardCount++){
                Card card = leftOverCards.get(cardCount);
                cardsOnHandList.add(card);
                leftOverCards.remove(card);
            }
            HandStrength handStrength = gameRank.getRankCategoryByHand().get(gameRank.getCardIdList(cardsOnHandList));
            playerHands.add(new PlayerHand(handStrength,cardsOnHandList.toArray(new Card[cardsOnHandList.size()])));
        }

        TableDeal tableDeal = new TableDeal();
        tableDeal.setPlayerHands(playerHands);
        tableDeal.setLeftOverCards(leftOverCards);

        return tableDeal;
    }

    public GameType getGameType() {
        return gameType;
    }
}
