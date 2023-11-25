package com.advanced.poker.service;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * The shuffle service uses the Fisher–Yates shuffle algorithm (forward and reverse) and the Sattolo algorithm
 * We are going to shuffle three times and randomly choose the sequence of the algorithms to avoid card counting.
 *

 */
@Service
public class ShufflerService {

    private ShuffleFactory shuffleFactory;



    public ShufflerService(){
        shuffleFactory =  ShuffleFactory.Builder.forBuilder().build();
    }

    /**
     * This manages the sequence of the shuffle algorithms.
     * "onside-out","modern","sattolo"
     *
     * The three methods are executed in a random sequence.
     * @param deck
     * @return the shuffle cards.
     */
    public Card[] shuffle(Deck deck){
        String[] methodSequence = {ShuffleFactory.IN_OUT_STRATEGY,ShuffleFactory.SATTOLO_STRATEGY,ShuffleFactory.MODERN_STRATEGY};
        Random rand = new Random();
        for(int index = 0; index < methodSequence.length; index ++){
            int randomPosition = rand.nextInt(methodSequence.length-index);
            String temp = methodSequence[randomPosition];
            methodSequence[randomPosition] = methodSequence[index];
            methodSequence[index] = temp;
        }

        final List<ShuffleStrategy> allStrategies = new ArrayList<>();
        Arrays.asList(methodSequence).stream().forEach(s -> {
            allStrategies.add(shuffleFactory.getStrategy(s));
        });

        final List<Card> cards = new ArrayList<>();

        cards.addAll(deck.cards());
        allStrategies
                .stream()
                .forEach( shuffleStrategy -> {
                    Card[] result = shuffleStrategy.shuffle(cards.toArray(new Card[cards.size()]));
                    cards.clear();
                    cards.addAll(Arrays.asList(result));
                });

        return cards.toArray(new Card[cards.size()]);
    }


    public Card[] shuffleFisherYatesInsideOut(Card[] shuffledFromDeck){
        Card[] shuffledDeck = shuffleFactory.getStrategy(ShuffleFactory.IN_OUT_STRATEGY)
                .shuffle(shuffledFromDeck);

        return shuffledDeck;
    }


    public Card[] shuffleFisherYatesMordernMethod(Card[] shuffledFromDeck){
        Card[] shuffledDeck = shuffleFactory.getStrategy(ShuffleFactory.MODERN_STRATEGY)
                .shuffle(shuffledFromDeck);

        return shuffledDeck;
    }

    public Card[] shuffleSattoloMethod(Card[] shuffledFromDeck){
        Card[] shuffledDeck = shuffleFactory.getStrategy(ShuffleFactory.SATTOLO_STRATEGY)
                .shuffle(shuffledFromDeck);

        return shuffledDeck;
    }

}
