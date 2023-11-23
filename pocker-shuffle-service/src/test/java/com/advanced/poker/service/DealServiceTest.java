package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.TableDeal;
import com.advanced.poker.service.CardDeckService;
import com.advanced.poker.service.DealService;
import com.advanced.poker.service.ShufflerService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DealServiceTest {

    private DealService dealService = new DealService();
    private CardDeckService cardDeckService = new CardDeckService();
    private ShufflerService shufflerService = new ShufflerService();
    @Test
    public void testValidCardDeal(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.deckType());
        assertNotNull(deck.deckType().name());
        Assert.assertEquals(deck.deckType().cardLimit(),52);

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.controller(deck);

        assertNotNull(shuffleOutput);

        Assert.assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });


        TableDeal deal = dealService.deal(Arrays.asList(shuffleOutput), 1);

        assertNotNull(deal);
        assertNotNull(deal.getLeftOverCards());
        assertNotEquals(52,deal.getLeftOverCards());
        assertEquals(1,deal.getPlayerHands().size());
        assertNotNull(deal.getPlayerHands().get(0).cards());
        assertNotNull(dealService.getGameType());
        assertEquals(dealService.getGameType().getCardsPerHand().intValue(),deal.getPlayerHands().get(0).cards().length);
        assertEquals(false,deal.getLeftOverCards().containsAll(Arrays.asList(deal.getPlayerHands().get(0).cards())));

    }
}
