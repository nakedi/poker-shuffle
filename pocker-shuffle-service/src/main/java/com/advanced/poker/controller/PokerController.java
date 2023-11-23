package com.advanced.poker.controller;

import com.advanced.poker.domain.Card;
import com.advanced.poker.domain.Deck;
import com.advanced.poker.domain.TableDeal;
import com.advanced.poker.dto.PokerGameDTO;
import com.advanced.poker.service.CardDeckService;
import com.advanced.poker.service.DealService;
import com.advanced.poker.service.PockerService;
import com.advanced.poker.service.ShufflerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class PokerController {

    private PockerService pockerService;


    public PokerController(PockerService pockerService) {
        this.pockerService = pockerService;
    }

    @GetMapping("/poker/shuffle_and_deal/{numberOfPlayers}")
    public @ResponseBody ResponseEntity<PokerGameDTO> shuffleAndDeal(@PathVariable(name="numberOfPlayers") Integer numberOfPlayers) {
        try {
            PokerGameDTO pokerGameDTO = pockerService.shuffleAndDeal(numberOfPlayers);
            return ResponseEntity.of(Optional.of(pokerGameDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
