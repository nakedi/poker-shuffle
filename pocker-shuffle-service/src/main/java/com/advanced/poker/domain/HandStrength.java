package com.advanced.poker.domain;

import java.io.Serializable;
import java.util.Objects;

public class HandStrength implements Serializable {
    private int rank;
    private String name;

    public HandStrength(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandStrength that = (HandStrength) o;
        return rank == that.rank && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name);
    }
}
