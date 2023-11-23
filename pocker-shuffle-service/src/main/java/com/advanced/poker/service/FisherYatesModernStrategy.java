package com.advanced.poker.service;

import com.advanced.poker.domain.Card;

import java.util.Arrays;
import java.util.Random;

public class FisherYatesModernStrategy implements ShuffleStrategy{


    /**
     * The modern version of the Fisher–Yates shuffle, designed for computer use, was introduced by Richard Durstenfeld
     * in 1964[4] and popularized by Donald E. Knuth in The Art of Computer Programming as "Algorithm P (Shuffling)".[5]
     * Neither Durstenfeld's article nor Knuth's first edition of The Art of Computer Programming acknowledged the work of
     * Fisher and Yates; they may not have been aware of it.[citation needed] Subsequent editions of Knuth's The Art of
     * Computer Programming mention Fisher and Yates' contribution.[6]
     *
     * The algorithm described by Durstenfeld is more efficient than that given by Fisher and Yates: whereas a naïve
     * computer implementation of Fisher and Yates' method would spend needless time counting the remaining numbers in
     * step 3 above, Durstenfeld's solution is to move the "struck" numbers to the end of the list by swapping them with
     * the last unstruck number at each iteration. This reduces the algorithm's time complexity to
     * O(n)
     * O(n) compared to
     * O(n2)
     * O(n^{2}) for the naïve implementation.[7] This change gives the following algorithm (for a zero-based array).
     *
     * -- To shuffle an array a of n elements (indices 0..n-1):
     * for i from n−1 down to 1 do
     *      j ← random integer such that 0 ≤ j ≤ i
     *      exchange a[j] and a[i]
     *
     * @param shuffledFromDeck
     * @return
     */
    @Override
    public Card[] shuffle(Card[] shuffledFromDeck) {
        Random rand = new Random();
        Card[] tempCardArray = Arrays.copyOf(shuffledFromDeck,shuffledFromDeck.length);
        for (int index = 0; index < shuffledFromDeck.length; index++){
            int randomPosition = rand.nextInt(shuffledFromDeck.length - index);
            Card tempCard = tempCardArray[randomPosition];
            tempCardArray[randomPosition] = tempCardArray[index];
            tempCardArray[index] = tempCard;
        }

        return tempCardArray;
    }

}
