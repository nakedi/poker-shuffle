package com.advanced.poker.domain;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.CardIDEnum;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardTest {

    public static final String ACE_OF_SPADES_NAME = "Ace of Spades";
    public static final String ACE_RANK = "A";
    public static final String SPADE_SUIT = "♠";

    @Test
    public void testBuildCorrectly(){
        Card card = Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_SPADES_ID)
                .withName(ACE_OF_SPADES_NAME)
                .withRank(ACE_RANK)
                .withSuit(SPADE_SUIT)
                .build();

        assertNotNull(card.getId());
        assertNotNull(card.getName());
        assertNotNull(card.getRank());
        assertNotNull(card.getSuit());

        assertEquals(CardIDEnum.ACE_OF_SPADES_ID,card.getId());
        assertEquals(ACE_OF_SPADES_NAME,card.getName());
        assertEquals(ACE_RANK,card.getRank());
        assertEquals(SPADE_SUIT,card.getSuit());
    }
}
