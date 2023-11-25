package com.advanced.poker.domain;

import java.util.*;

/**
 * The ranking Category
 */
public class FiveCardRankCategory extends GameRank{
    private Map<TreeSet<CardIDEnum>,HandStrength> rankCategoryByHand = new HashMap<>();

    public FiveCardRankCategory() {

        CardIDEnum[] straightFlush = {
            CardIDEnum.JACK_OF_CLUBS_ID,
                    CardIDEnum.TEN_OF_CLUBS_ID,
                    CardIDEnum.NINE_OF_CLUBS_ID,
                    CardIDEnum.EIGHT_OF_CLUBS_ID,
                    CardIDEnum.SEVEN_OF_CLUBS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(straightFlush)),new HandStrength(1,"Straight flush"));

        CardIDEnum[] fourOfaKind = {
                CardIDEnum.FIVE_OF_CLUBS_ID,
                CardIDEnum.FIVE_OF_DIAMONDS_ID,
                CardIDEnum.FIVE_OF_HEARTS_ID,
                CardIDEnum.FIVE_OF_SPADES_ID,
                CardIDEnum.TWO_OF_DIAMONDS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(fourOfaKind)),new HandStrength(2,"Four of a kind"));

        CardIDEnum[] fullHouse = {
                CardIDEnum.SIX_OF_SPADES_ID,
                CardIDEnum.SEVEN_OF_HEARTS_ID,
                CardIDEnum.SEVEN_OF_DIAMONDS_ID,
                CardIDEnum.KING_OF_CLUBS_ID,
                CardIDEnum.KING_OF_HEARTS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(fullHouse)), new HandStrength(3,"Full house"));

        CardIDEnum[] flush = {
                CardIDEnum.JACK_OF_DIAMONDS_ID,
                CardIDEnum.NINE_OF_DIAMONDS_ID,
                CardIDEnum.EIGHT_OF_DIAMONDS_ID,
                CardIDEnum.FOUR_OF_DIAMONDS_ID,
                CardIDEnum.THREE_OF_DIAMONDS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(flush)),new HandStrength(4,"Flush"));

        CardIDEnum[] straight = {
                CardIDEnum.TEN_OF_DIAMONDS_ID,
                CardIDEnum.NINE_OF_SPADES_ID,
                CardIDEnum.EIGHT_OF_HEARTS_ID,
                CardIDEnum.FOUR_OF_DIAMONDS_ID,
                CardIDEnum.THREE_OF_DIAMONDS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(straight)),new HandStrength(5,"Straight"));

        CardIDEnum[] threeOfAKind = {
                CardIDEnum.QUEEN_OF_CLUBS_ID,
                CardIDEnum.QUEEN_OF_SPADES_ID,
                CardIDEnum.QUEEN_OF_HEARTS_ID,
                CardIDEnum.NINE_OF_HEARTS_ID,
                CardIDEnum.TWO_OF_SPADES_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(threeOfAKind)),new HandStrength(6,"Three of a kind"));

        CardIDEnum[] twoPair = {
                CardIDEnum.JACK_OF_HEARTS_ID,
                CardIDEnum.JACK_OF_SPADES_ID,
                CardIDEnum.THREE_OF_CLUBS_ID,
                CardIDEnum.THREE_OF_SPADES_ID,
                CardIDEnum.TWO_OF_HEARTS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(twoPair)), new HandStrength(7,"Two pair"));

        CardIDEnum[] onePair = {
                CardIDEnum.TEN_OF_SPADES_ID,
                CardIDEnum.TEN_OF_HEARTS_ID,
                CardIDEnum.EIGHT_OF_SPADES_ID,
                CardIDEnum.SEVEN_OF_HEARTS_ID,
                CardIDEnum.FOUR_OF_CLUBS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(onePair)), new HandStrength(8,"One pair"));

        CardIDEnum[] highCard = {
                CardIDEnum.KING_OF_DIAMONDS_ID,
                CardIDEnum.QUEEN_OF_DIAMONDS_ID,
                CardIDEnum.SEVEN_OF_SPADES_ID,
                CardIDEnum.FOUR_OF_CLUBS_ID,
                CardIDEnum.THREE_OF_HEARTS_ID
        };
        rankCategoryByHand.put(new TreeSet<>(Arrays.asList(highCard)),new  HandStrength(9,"High card"));

        rankCategoryByHand = Collections.unmodifiableMap(rankCategoryByHand);
    }

    public Map<TreeSet<CardIDEnum>, HandStrength> getRankCategoryByHand() {
        return rankCategoryByHand;
    }
}
