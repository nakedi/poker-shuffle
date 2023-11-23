package com.advanced.poker;

import com.advanced.poker.config.PockerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PockerShufflerApplication {

    private static PockerConfig pockerConfig = new PockerConfig();
    public static void main(String[] arg){
        SpringApplication.run(PockerShufflerApplication.class, arg);
    }

}
