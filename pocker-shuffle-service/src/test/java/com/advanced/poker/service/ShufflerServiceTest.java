package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.service.CardDeckService;
import com.advanced.poker.service.ShufflerService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShufflerServiceTest {
    ShufflerService shufflerService = new ShufflerService();
    CardDeckService cardDeckService = new CardDeckService();
    @Test
    public void testFisherModernMethod(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.shuffleFisherYatesMordernMethod(shuffleInput);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });
    }

    @Test
    public void testFisherInsideOutsideMethod(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.shuffleFisherYatesInsideOut(shuffleInput);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });
    }

    @Test
    public void testSattoloMethod(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.shuffleSattoloMethod(shuffleInput);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });
    }

    @Test
    public void testContoller(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.controller(deck);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });
    }
}
