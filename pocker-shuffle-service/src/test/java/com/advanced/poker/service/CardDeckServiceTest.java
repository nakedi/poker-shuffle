package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.CardIDEnum;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.service.CardDeckService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardDeckServiceTest {

    public static final String ACE_OF_SPADES_NAME = "Ace of Spades";
    public static final String ACE_RANK = "A";
    public static final String SPADE_SUIT = "♠";

    @Test
    public void testDeckBuild(){
        CardDeckService cardDeckService = new CardDeckService();

        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.deckType());
        assertNotNull(deck.deckType().name());
        assertEquals(deck.deckType().cardLimit(),52);

        assertNotNull(deck.cards());
        assertEquals(52,deck.cards().size());


        Card card = Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_SPADES_ID)
                .withName(ACE_OF_SPADES_NAME)
                .withRank(ACE_RANK)
                .withSuit(SPADE_SUIT)
                .build();

        assertEquals(true,deck.cards().contains(card));

        assertEquals(true,deck.cards().containsAll(cardDeckService.buildSpades()));
        assertEquals(true,deck.cards().containsAll(cardDeckService.buildDimonds()));
        assertEquals(true,deck.cards().containsAll(cardDeckService.buildHearts()));
        assertEquals(true,deck.cards().containsAll(cardDeckService.buildClubs()));




    }


    @Test
    public void testDeckBuildIncorrectCard(){
        CardDeckService cardDeckService = new CardDeckService();

        Deck deck = cardDeckService.buildCardDeck();

        assertNotNull(deck);
        assertNotNull(deck.deckType());
        assertNotNull(deck.deckType().name());
        assertEquals(deck.deckType().cardLimit(),52);

        Card card = Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_SPADES_ID)
                .withName("Joker")
                .withRank(ACE_RANK)
                .withSuit(SPADE_SUIT)
                .build();

        assertEquals(false,deck.cards().contains(card));
    }
}
