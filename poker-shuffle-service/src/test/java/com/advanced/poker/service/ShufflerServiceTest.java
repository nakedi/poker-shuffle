package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
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
        Card[] shuffleOutput =  shufflerService.shuffle(deck);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });
    }

    @Test
    public void testForDuplicates(){
        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());

        Card[] shuffleInput  =  Arrays.copyOf(deck.cards().toArray(new Card[deck.cards().size()]),deck.cards().size());
        assertNotNull(shuffleInput);
        Card[] shuffleOutput =  shufflerService.shuffle(deck);

        assertNotNull(shuffleOutput);

        assertThrows(AssertionError.class, () -> {
            Assert.assertArrayEquals(shuffleInput, shuffleOutput);
        });

        Card[] duplicateCheck = new TreeSet<>(Arrays.asList(shuffleOutput)).toArray(new Card[0]);

        assertEquals(shuffleOutput.length,duplicateCheck.length);
    }
}
