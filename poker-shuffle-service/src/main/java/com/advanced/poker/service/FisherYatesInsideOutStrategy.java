package com.advanced.poker.service;

import com.advanced.poker.domain.Card;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class FisherYatesInsideOutStrategy implements ShuffleStrategy{

    /**
     * The Fisher–Yates shuffle, as implemented by Durstenfeld, is an in-place shuffle. That is, given a preinitialized
     * array, it shuffles the elements of the array in place, rather than producing a shuffled copy of the array. This
     * can be an advantage if the array to be shuffled is large.
     *
     * To simultaneously initialize and shuffle an array, a bit more efficiency can be attained by doing an "inside-out"
     * version of the shuffle. In this version, one successively places element number i into a random position among the
     * first i positions in the array, after moving the element previously occupying that position to position i.
     * In case the random position happens to be number i, this "move" (to the same place) involves an uninitialised value,
     * but that does not matter, as the value is then immediately overwritten. No separate initialization is needed,
     * and no exchange is performed. In the common case where source is defined by some simple function, such as the
     * integers from 0 to n − 1, source can simply be replaced with the function since source is never altered during execution.
     *
     * To initialize an array a of n elements to a randomly shuffled copy of source, both 0-based:
     *   for i from 0 to n − 1 do
     *       j ← random integer such that 0 ≤ j ≤ i
     *       if j ≠ i
     *           a[i] ← a[j]
     *       a[j] ← source[i]
     *
     * @param shuffledFromDeck
     * @return Card[] this array is a shuffled version of what is in the deck.
     */
    @Override
    public Card[] shuffle(Card[] shuffledFromDeck) {
        Random rand = new Random();
        Card[] tempCardArray = Arrays.copyOf(shuffledFromDeck,shuffledFromDeck.length);
        Card[] result = new TreeSet<>(Arrays.asList(tempCardArray)).toArray(new Card[0]);

        for(int index = 0 ; index < shuffledFromDeck.length; index ++) {
            int randomPosition = rand.nextInt(shuffledFromDeck.length - index);
            if(index != randomPosition){
                Card temp = tempCardArray[index];
                tempCardArray[index] = tempCardArray[randomPosition];
                tempCardArray[randomPosition] = temp;
            }

            if(checkDuplicate(shuffledFromDeck[index],tempCardArray) == -1) {
                tempCardArray[randomPosition] = shuffledFromDeck[index];
            }

        }

        return tempCardArray;
    }

    private int checkDuplicate(Card card ,Card[] tempCardArray){
        for (int index =0;index < tempCardArray.length;index++){
            if(card.equals(tempCardArray[index])){
                return index;
            }
        }

        return -1;
    }
}
