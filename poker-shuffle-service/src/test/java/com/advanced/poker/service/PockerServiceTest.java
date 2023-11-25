package com.advanced.poker.service;

import com.advanced.poker.dto.PokerGameDTO;
import com.advanced.poker.service.CardDeckService;
import com.advanced.poker.service.DealService;
import com.advanced.poker.service.PockerService;
import com.advanced.poker.service.ShufflerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PockerServiceTest {

    private PockerService pockerService;


    @Before
    public void initialize(){
        DealService dealService = new DealService();
        ShufflerService shufflerService = new ShufflerService();
        CardDeckService cardDeckService = new CardDeckService();

        pockerService = new PockerService(dealService,cardDeckService,shufflerService);
    }
    @Test
    public void testShuffleAndDealNegativePlayers(){
        Assert.assertThrows(RuntimeException.class, () -> {
            pockerService.shuffleAndDeal(-3);
        });
    }
    @Test
    public void testShuffleAndDealInvalidNumberOfPlayers(){
        Assert.assertThrows(RuntimeException.class, () -> {
            pockerService.shuffleAndDeal(11);
        });
    }
    @Test
    public void testShuffleAndDeal(){
        PokerGameDTO pokerGameDTO = pockerService.shuffleAndDeal(1);
        Assert.assertNotNull(pokerGameDTO);
        Assert.assertNotNull(pokerGameDTO.getGameType());
        Assert.assertNotNull(pokerGameDTO.getDeck());
        Assert.assertNotNull(pokerGameDTO.getTabelDeal());
    }

}
