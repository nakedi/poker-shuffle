package com.advanced.poker.domain;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable,Comparable<Card> {
    private CardIDEnum id;
    private String name;
    private String suit;
    private String rank;

    public Card(){

    }

    public CardIDEnum getId() {
        return id;
    }

    public void setId(CardIDEnum id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id && Objects.equals(name, card.name) && Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, suit, rank);
    }

    @Override
    public int compareTo(Card card) {
        if(card == null){
            return -1;
        }
        if(card.equals(this)){
            return 0;
        }
        return this.id.compareTo(card.id);
    }


    public static class Builder{
        private CardIDEnum id;
        private String name;
        private String suit;
        private String rank;
        private String unicodeRepOfId;
        private Builder(){
            super();
        }

        public static Builder forCard(){
            return new Builder();
        }

        public Builder withId(CardIDEnum id){
            this.id = id;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withSuit(String suit){
            this.suit = suit;
            return this;
        }

        public Builder withRank(String rank){
            this.rank = rank;
            return this;
        }

        public Card build(){
            Card card = new Card();
            card.setId(this.id);
            card.setName(this.name);
            card.setRank(this.rank);
            card.setSuit(this.suit);

            return card;
        }
    }
}
