package com.advanced.poker.dto;

import java.io.Serializable;

public class HandStrengthDTO implements Serializable {
    private int rank;
    private String name;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        private int rank;
        private String name;

        private Builder(){
            super();
        }
        public static Builder forHandStrength(){
            return new Builder();
        }
        public Builder withRank(int rank){
            this.rank = rank;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public HandStrengthDTO build(){
            HandStrengthDTO handStrengthDTO = new HandStrengthDTO();
            handStrengthDTO.setName(this.name);
            handStrengthDTO.setRank(this.rank);
            return handStrengthDTO;
        }

    }
}
