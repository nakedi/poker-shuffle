package com.advanced.poker.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShuffleFactory {

    private Map<String,ShuffleStrategy>strategyMap = new HashMap<>();

    public static final String IN_OUT_STRATEGY = "onside-out";
    public static final String MODERN_STRATEGY = "modern";
    public static final String SATTOLO_STRATEGY = "sattolo";

    public ShuffleFactory() {
        strategyMap.put(IN_OUT_STRATEGY,new FisherYatesInsideOutStrategy());
        strategyMap.put(MODERN_STRATEGY,new FisherYatesModernStrategy());
        strategyMap.put(SATTOLO_STRATEGY,new SattoloStrategy());
    }

    public ShuffleStrategy getStrategy(String strategyKey){
        return strategyMap.get(strategyKey);
    }

    public Collection<ShuffleStrategy> getAllStrategies(){
        return strategyMap.values();
    }

    public static class Builder{
        private Builder(){
            super();
        }

        public static Builder forBuilder(){
            return new Builder();
        }

        public ShuffleFactory build(){
            ShuffleFactory shuffleFactory = new ShuffleFactory();
            return  shuffleFactory;
        }
    }
}
