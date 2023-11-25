package com.advance.poker.ui.controller;

import com.advance.poker.ui.dto.CardDTO;
import com.advance.poker.ui.dto.PlayerHandDTO;
import com.advance.poker.ui.dto.PokerGameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.advance.poker.ui.service.ConsoleService;
import com.advance.poker.ui.service.PokerGameService;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PockerGameController {

    private ConsoleService consoleService;
    private PokerGameService pokerGameService;

    @Autowired
    public PockerGameController(ConsoleService consoleService,PokerGameService pokerGameService) {
        this.consoleService = consoleService;
        this.pokerGameService = pokerGameService;
    }


    public void controller(){
        consoleService.printWelcomeMessage();
        String menuChoice = "";
        do {

            PokerGameDTO pokerGameDTO = null;
            String numberOfPlayers = consoleService.printAndScanForNumber("How many players in your game: " , consoleService.RESET);
            consoleService.println("Shuffling...Shuffling...Shuffling...",consoleService.RESET);
            try {
                pokerGameDTO = pokerGameService.shuffleAndDeal(numberOfPlayers);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (pokerGameDTO.getErrorDTO() != null && pokerGameDTO.getErrorDTO().getMessage() != null) {
                consoleService.println("Error from service : " + pokerGameDTO.getErrorDTO().getMessage(), consoleService.RED);
            } else {
                StringBuilder cardsOnHand = new StringBuilder();
                for (PlayerHandDTO playerHandDTO : pokerGameDTO.getTabelDeal().getPlayerHands()) {
                    for (CardDTO card : playerHandDTO.getCards()) {
                        cardsOnHand.append(card.getRank() + card.getSuit() + " ");
                    }
                    consoleService.println("Your cards on hand : " + cardsOnHand, consoleService.GREEN);
                    consoleService.println("You have  : " + playerHandDTO.getHandStrength().getName(), consoleService.GREEN);
                    cardsOnHand = new StringBuilder();
                }
            }
            menuChoice = consoleService.printAndScanForString("Menu E=Exit, P=Play again", "E,P", consoleService.RESET);
        }while(!menuChoice.trim().equalsIgnoreCase("E"));

        consoleService.println("Thank you for playing - GOOD BEYE ", consoleService.RESET);
    }
}
