package com.advanced.poker.domain;

import com.advanced.poker.domain.CardIDEnum;
import com.advanced.poker.domain.HandStrength;
import com.advanced.poker.domain.FiveCardRankCategory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RankingCategoryTest {

    @Test
    public void testContainsBadHand(){
        FiveCardRankCategory rankingCategory = new FiveCardRankCategory();


        CardIDEnum[] highCard = {
                CardIDEnum.KING_OF_DIAMONDS_ID,
                CardIDEnum.QUEEN_OF_DIAMONDS_ID,
                CardIDEnum.SEVEN_OF_SPADES_ID,
                CardIDEnum.FOUR_OF_CLUBS_ID,
                CardIDEnum.THREE_OF_HEARTS_ID
        };

        HandStrength handStrength = rankingCategory.getRankCategoryByHand().get(new TreeSet<>(Arrays.asList(highCard)));
        assertNotNull(handStrength);
        assertEquals(new HandStrength(9,"High card"),handStrength);
    }

    @Test
    public void testContainsBadHandChangeKeySequence(){
        FiveCardRankCategory rankingCategory = new FiveCardRankCategory();


        CardIDEnum[] highCard = {
                CardIDEnum.KING_OF_DIAMONDS_ID,
                CardIDEnum.QUEEN_OF_DIAMONDS_ID,
                CardIDEnum.SEVEN_OF_SPADES_ID,
                CardIDEnum.THREE_OF_HEARTS_ID,
                CardIDEnum.FOUR_OF_CLUBS_ID,

        };

        HandStrength handStrength = rankingCategory.getRankCategoryByHand().get(new TreeSet<>(Arrays.asList(highCard)));
        assertNotNull(handStrength);
        assertEquals(new HandStrength(9,"High card"),handStrength);
    }

    @Test
    public void testUpdatingUnupdatableMap(){
        FiveCardRankCategory rankingCategory = new FiveCardRankCategory();

        CardIDEnum[] highCard = {
                CardIDEnum.THREE_OF_HEARTS_ID,
                CardIDEnum.KING_OF_DIAMONDS_ID,
                CardIDEnum.QUEEN_OF_DIAMONDS_ID,
                CardIDEnum.SEVEN_OF_SPADES_ID,
                CardIDEnum.FOUR_OF_CLUBS_ID,
        };

        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            rankingCategory.getRankCategoryByHand().put(new TreeSet<>(Arrays.asList(highCard)),new HandStrength(9,"High card"));
        });

    }
}
