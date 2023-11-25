package com.advance.poker.ui.dto;

/**
 * @class CardIDEnum
 *
 * Enumerators for the card IDs. These are actually Unicodes for displaying the card as a ful picture on the console
 * not just the suit.
 */
public enum CardIDEnum {

    /**
     * Codes for the spades
     */
    ACE_OF_SPADES_ID("1F0A1"),
    TWO_OF_SPADES_ID("1F0A2"),
    THREE_OF_SPADES_ID("1F0A3"),
    FOUR_OF_SPADES_ID("1F0A4"),
    FIVE_OF_SPADES_ID("1F0A5"),
    SIX_OF_SPADES_ID("1F0A6"),
    SEVEN_OF_SPADES_ID("1F0A7"),
    EIGHT_OF_SPADES_ID("1F0A8"),
    NINE_OF_SPADES_ID("1F0A9"),
    TEN_OF_SPADES_ID("1F0AA"),
    JACK_OF_SPADES_ID("1F0AB"),
    KING_OF_SPADES_ID("1F0AE"),
    QUEEN_OF_SPADES_ID("1F0AD"),

    /**
     * Codes for the spades
     */
    ACE_OF_CLUBS_ID("1F0D1"),
    TWO_OF_CLUBS_ID("1F0D2"),
    THREE_OF_CLUBS_ID("1F0D3"),
    FOUR_OF_CLUBS_ID("1F0D4"),
    FIVE_OF_CLUBS_ID("1F0D5"),
    SIX_OF_CLUBS_ID("1F0D6"),
    SEVEN_OF_CLUBS_ID("1F0D7"),
    EIGHT_OF_CLUBS_ID("1F0D8"),
    NINE_OF_CLUBS_ID("1F0D9"),
    TEN_OF_CLUBS_ID("1F0DA"),
    JACK_OF_CLUBS_ID("1F0DB"),
    KING_OF_CLUBS_ID("1F0DE"),
    QUEEN_OF_CLUBS_ID("1F0DD"),
    /**
     * Codes for the hearts
     */
    ACE_OF_HEARTS_ID("1F0B1"),
    TWO_OF_HEARTS_ID("1F0B2"),
    THREE_OF_HEARTS_ID("1F0B3"),
    FOUR_OF_HEARTS_ID("1F0B4"),
    FIVE_OF_HEARTS_ID("1F0B5"),
    SIX_OF_HEARTS_ID("1F0B6"),
    SEVEN_OF_HEARTS_ID("1F0B7"),
    EIGHT_OF_HEARTS_ID("1F0B8"),
    NINE_OF_HEARTS_ID("1F0B9"),
    TEN_OF_HEARTS_ID("1F0BA"),
    JACK_OF_HEARTS_ID("1F0BB"),
    KING_OF_HEARTS_ID("1F0BE"),
    QUEEN_OF_HEARTS_ID("1F0BD"),
    /**
     * Codes for the diamonds
     */
    ACE_OF_DIAMONDS_ID("1F0C1"),
    TWO_OF_DIAMONDS_ID("1F0C2"),
    THREE_OF_DIAMONDS_ID("1F0C3"),
    FOUR_OF_DIAMONDS_ID("1F0C4"),
    FIVE_OF_DIAMONDS_ID("1F0C5"),
    SIX_OF_DIAMONDS_ID("1F0C6"),
    SEVEN_OF_DIAMONDS_ID("1F0C7"),
    EIGHT_OF_DIAMONDS_ID("1F0C8"),
    NINE_OF_DIAMONDS_ID("1F0C9"),
    TEN_OF_DIAMONDS_ID("1F0CA"),
    JACK_OF_DIAMONDS_ID("1F0CB"),
    KING_OF_DIAMONDS_ID("1F0CE"),
    QUEEN_OF_DIAMONDS_ID("1F0CD");

    private String cardId;

    CardIDEnum(String cardId){
        this.cardId = cardId;
    }

    public String getCardId(){
        return this.cardId;
    }


}
