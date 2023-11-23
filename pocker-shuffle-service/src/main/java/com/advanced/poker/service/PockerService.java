package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.TableDeal;
import com.advanced.poker.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class PockerService {

    private DealService dealService;
    private CardDeckService cardDeckService;
    private ShufflerService shufflerService;

    @Autowired
    public PockerService(DealService dealService, CardDeckService cardDeckService, ShufflerService shufflerService) {
        this.dealService = dealService;
        this.cardDeckService = cardDeckService;
        this.shufflerService = shufflerService;
    }
    public PokerGameDTO shuffleAndDeal(Integer numberOfPlayers){
        if(numberOfPlayers < 1){
            throw new RuntimeException("We can only deal with 1 or more players not \""+numberOfPlayers+"\"");
        }
        Deck deck = cardDeckService.buildCardDeck();
        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        Card[] shuffleOutput =  shufflerService.controller(deck);
        TableDeal deal = dealService.deal(Arrays.asList(shuffleOutput), numberOfPlayers);

        PokerGameDTO pokerGame = PokerGameDTO.Builder.forPokerGame()
                .withDeck(DeckDTO.Builder.forDeck()
                        .withDeckType(DeckTypeDTO.Builder.forDeclType()
                                .withCardLimit(deck.deckType().cardLimit())
                                .withName(deck.deckType().name())
                                .build())
                        .withCards(deck.cards().stream().map(card -> {
                            return CardDTO.Builder.forCard()
                                    .withId(card.getId())
                                    .withName(card.getName())
                                    .withRank(card.getRank())
                                    .withSuit(card.getSuit())
                                    .build();
                        }).collect(Collectors.toList()))
                        .build())
                .withGameType(GameTypeDTO.Builder.forGameType()
                        .withType(dealService.getGameType().getType())
                        .withCardsPerHand(dealService.getGameType().getCardsPerHand())
                        .build())
                .withTableDeal(TableDealDTO.Builder.forTableDeal()
                        .withLeftOverCards(deal.getLeftOverCards().stream().map(card -> {
                            return CardDTO.Builder.forCard()
                                    .withId(card.getId())
                                    .withName(card.getName())
                                    .withRank(card.getRank())
                                    .withSuit(card.getSuit())
                                    .build();
                        }).collect(Collectors.toList()))
                        .withPlayerHands(deal.getPlayerHands().stream().map(playerHand -> {
                            return PlayerHandDTO.Builder.forPlayerHand()
                                    .withHandStrength(HandStrengthDTO.Builder.forHandStrength()
                                            .withName(playerHand.handStrength() != null ? playerHand.handStrength().getName() : null)
                                            .withRank(playerHand.handStrength() != null ? playerHand.handStrength().getRank() : 0)
                                            .build())
                                    .withCards(Arrays.asList(playerHand.cards()).stream().map(card -> {
                                        return CardDTO.Builder.forCard()
                                                .withId(card.getId())
                                                .withName(card.getName())
                                                .withRank(card.getRank())
                                                .withSuit(card.getSuit())
                                                .build();
                                    }).collect(Collectors.toList()))
                                    .build();
                        }).collect(Collectors.toList()))
                        .build()
                )
                .build();

        return pokerGame;
    }
}
