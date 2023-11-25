package com.advanced.poker.domain;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.DeckType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class DeckTest {

    private final static String STANDARD_52_CARD_DECK = "Standard 52 Card Deck";

    @Test
    public void testMaxLimitReached(){
        DeckType deckType = new DeckType(STANDARD_52_CARD_DECK,52);

        List<Card> cards = new ArrayList<>();

        for(int index = 0 ; index <= 53 ; index++){
            cards.add(Card.Builder.forCard().build());
        }


        IllegalArgumentException illegalArgumentException = Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Deck(deckType, cards);
        });

    }

    @Test
    public void testMaxLimitNotReached(){
        DeckType deckType = new DeckType(STANDARD_52_CARD_DECK,52);

        List<Card> cards = new ArrayList<>();

        for(int index = 0 ; index <= 51 ; index++){
            cards.add(Card.Builder.forCard().build());
        }


        Deck deck = new Deck(deckType, cards);

        assertEquals(52,deck.cards().size());
    }
}
