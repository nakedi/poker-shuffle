package com.advanced.poker;

import com.advanced.poker.config.PockerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration()
public class PockerShufflerApplication {

    private static PockerConfig pockerConfig = new PockerConfig();
    public static void main(String[] arg){
        SpringApplication.run(PockerShufflerApplication.class, arg);
    }

}
