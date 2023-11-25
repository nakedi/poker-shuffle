package com.advance.poker.ui;


import com.advance.poker.ui.controller.PockerGameController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class PokerShuffleConsoleApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(PokerShuffleConsoleApplication.class);

    private PockerGameController pockerGameController;

    @Autowired
    public PokerShuffleConsoleApplication(PockerGameController pockerGameController) {
        this.pockerGameController = pockerGameController;
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(PokerShuffleConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        this.pockerGameController.controller();
    }
}
