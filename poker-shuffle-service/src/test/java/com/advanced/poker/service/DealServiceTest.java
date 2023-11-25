package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.TableDeal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
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
        Card[] shuffleOutput =  shufflerService.shuffle(deck);

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

        assertEquals(false,deal.getLeftOverCards().containsAll(Arrays.asList(deal.getPlayerHands().get(0).cards())));

    }

}
