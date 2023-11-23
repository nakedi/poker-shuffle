package com.advanced.poker.service;

import com.advanced.poker.domain.Card;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public interface ShuffleStrategy {

    Card[] shuffle(Card[] shuffledFromDeck);

}
