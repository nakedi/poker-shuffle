package com.advanced.poker.service;

import com.advanced.poker.domain.Card;

import java.util.Arrays;
import java.util.Random;

public class SattoloStrategy implements ShuffleStrategy{


    /**
     * A very similar algorithm was published in 1986 by Sandra Sattolo for generating uniformly distributed cycles of
     * (maximal) length n.[8][9] The only difference between Durstenfeld's and Sattolo's algorithms is that in the latter,
     * in step 2 above, the random number j is chosen from the range between 1 and i−1 (rather than between 1 and i) inclusive.
     * This simple change modifies the algorithm so that the resulting permutation always consists of a single cycle.
     *
     * @param shuffledFromDeck
     * @return
     */
    @Override
    public Card[] shuffle(Card[] shuffledFromDeck) {
        Random rand = new Random();
        Card[] tempCardArray = Arrays.copyOf(shuffledFromDeck,shuffledFromDeck.length);
        for (int index = shuffledFromDeck.length-1; index > 0; index--){
            int randomPosition = rand.nextInt(index);
            Card tempCard = tempCardArray[randomPosition];
            tempCardArray[randomPosition] = tempCardArray[index];
            tempCardArray[index] = tempCard;
        }

        return tempCardArray;
    }

}
