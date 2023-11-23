package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.CardIDEnum;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.DeckType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardDeckService {

    private final static String STANDARD_52_CARD_DECK = "Standard 52 Card Deck";

    public Deck buildCardDeck(){
        List<Card> cards = new ArrayList<>();
        cards.addAll(this.buildClubs());
        cards.addAll(this.buildHearts());
        cards.addAll(this.buildDimonds());
        cards.addAll(this.buildSpades());
        duplicateCheck(cards);

        Deck deck = new Deck(new DeckType(STANDARD_52_CARD_DECK, 52), cards);

        return deck;
    }

    private void duplicateCheck(List<Card> cards){
        Set<Card> cardSet = new HashSet<Card>();
        for(Card card : cards){
            if(!cardSet.isEmpty()){
                if(cardSet.contains(card)) {
                    throw new IllegalArgumentException("Duplicate card found " + card);
                }
            }
            cardSet.add(card);
        }
    }

    public List<Card> buildSpades(){
        List<Card> cards = new ArrayList<>();

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_SPADES_ID )
                .withName("Ace of Spades")
                .withRank("A")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TWO_OF_SPADES_ID )
                .withName("Two of Spades")
                .withRank("2")
                .withSuit("♠")
                .build());
        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.THREE_OF_SPADES_ID )
                .withName("Three of Spades")
                .withRank("3")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FOUR_OF_SPADES_ID )
                .withName("Four of Spades")
                .withRank("4")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FIVE_OF_SPADES_ID )
                .withName("Five of Spades")
                .withRank("5")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SIX_OF_SPADES_ID )
                .withName("Six of Spades")
                .withRank("6")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SEVEN_OF_SPADES_ID )
                .withName("Seven of Spades")
                .withRank("7")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.EIGHT_OF_SPADES_ID )
                .withName("Eight of Spades")
                .withRank("8")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.NINE_OF_SPADES_ID )
                .withName("Nine of Spades")
                .withRank("9")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TEN_OF_SPADES_ID )
                .withName("Ten of Spades")
                .withRank("10")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.JACK_OF_SPADES_ID )
                .withName("Jack of Spades")
                .withRank("J")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.KING_OF_SPADES_ID )
                .withName("King of Spades")
                .withRank("K")
                .withSuit("♠")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.QUEEN_OF_SPADES_ID )
                .withName("Queen of Spades")
                .withRank("Q")
                .withSuit("♠")
                .build());

        return cards;
    }

    public List<Card> buildClubs(){
        List<Card> cards = new ArrayList<>();

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_CLUBS_ID )
                .withName("Ace of Clubs")
                .withRank("A")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TWO_OF_CLUBS_ID )
                .withName("Two of Clubs")
                .withRank("2")
                .withSuit("♣")
                .build());
        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.THREE_OF_CLUBS_ID )
                .withName("Three of Clubs")
                .withRank("3")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FOUR_OF_CLUBS_ID )
                .withName("Four of Clubs")
                .withRank("4")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FIVE_OF_CLUBS_ID )
                .withName("Five of Clubs")
                .withRank("5")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SIX_OF_CLUBS_ID )
                .withName("Six of Clubs")
                .withRank("6")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SEVEN_OF_CLUBS_ID )
                .withName("Seven of Clubs")
                .withRank("7")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.EIGHT_OF_CLUBS_ID )
                .withName("Eight of Clubs")
                .withRank("8")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.NINE_OF_CLUBS_ID )
                .withName("Nine of Clubs")
                .withRank("9")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TEN_OF_CLUBS_ID )
                .withName("Ten of Clubs")
                .withRank("10")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.JACK_OF_CLUBS_ID )
                .withName("Jack of Clubs")
                .withRank("J")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.KING_OF_CLUBS_ID )
                .withName("King of Clubs")
                .withRank("K")
                .withSuit("♣")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.QUEEN_OF_CLUBS_ID )
                .withName("Queen of Clubs")
                .withRank("Q")
                .withSuit("♣")
                .build());

        return cards;
    }

    public List<Card> buildHearts(){
        List<Card> cards = new ArrayList<>();

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_HEARTS_ID )
                .withName("Ace of Hearts")
                .withRank("A")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TWO_OF_HEARTS_ID )
                .withName("Two of Hearts")
                .withRank("2")
                .withSuit("♥")
                .build());
        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.THREE_OF_HEARTS_ID )
                .withName("Three of Hearts")
                .withRank("3")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FOUR_OF_HEARTS_ID )
                .withName("Four of Hearts")
                .withRank("4")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FIVE_OF_HEARTS_ID )
                .withName("Five of Hearts")
                .withRank("5")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SIX_OF_HEARTS_ID )
                .withName("Six of Hearts")
                .withRank("6")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SEVEN_OF_HEARTS_ID )
                .withName("Seven of Hearts")
                .withRank("7")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.EIGHT_OF_HEARTS_ID )
                .withName("Eight of Hearts")
                .withRank("8")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.EIGHT_OF_HEARTS_ID )
                .withName("Nine of Hearts")
                .withRank("9")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TEN_OF_HEARTS_ID )
                .withName("Ten of Hearts")
                .withRank("10")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.JACK_OF_HEARTS_ID )
                .withName("Jack of Hearts")
                .withRank("J")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.KING_OF_DIAMONDS_ID )
                .withName("King of Hearts")
                .withRank("K")
                .withSuit("♥")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.QUEEN_OF_HEARTS_ID )
                .withName("Queen of Hearts")
                .withRank("Q")
                .withSuit("♥")
                .build());

        return cards;
    }


    public List<Card> buildDimonds(){
        List<Card> cards = new ArrayList<>();

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.ACE_OF_DIAMONDS_ID )
                .withName("Ace of Dimonds")
                .withRank("A")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TWO_OF_DIAMONDS_ID )
                .withName("Two of Dimonds")
                .withRank("2")
                .withSuit("♦")
                .build());
        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.THREE_OF_DIAMONDS_ID )
                .withName("Three of Dimonds")
                .withRank("3")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FOUR_OF_DIAMONDS_ID )
                .withName("Four of Dimonds")
                .withRank("4")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.FIVE_OF_DIAMONDS_ID )
                .withName("Five of Dimonds")
                .withRank("5")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SIX_OF_DIAMONDS_ID )
                .withName("Six of Dimonds")
                .withRank("6")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.SEVEN_OF_DIAMONDS_ID )
                .withName("Seven of Dimonds")
                .withRank("7")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.EIGHT_OF_DIAMONDS_ID )
                .withName("Eight of Dimonds")
                .withRank("8")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.NINE_OF_DIAMONDS_ID )
                .withName("Nine of Dimonds")
                .withRank("9")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.TEN_OF_DIAMONDS_ID )
                .withName("Ten of Dimonds")
                .withRank("10")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.JACK_OF_DIAMONDS_ID )
                .withName("Jack of Dimonds")
                .withRank("J")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.KING_OF_DIAMONDS_ID )
                .withName("King of Dimonds")
                .withRank("K")
                .withSuit("♦")
                .build());

        cards.add(Card.Builder.forCard()
                .withId(CardIDEnum.QUEEN_OF_DIAMONDS_ID )
                .withName("Queen of Dimonds")
                .withRank("Q")
                .withSuit("♦")
                .build());

        return cards;
    }
}
