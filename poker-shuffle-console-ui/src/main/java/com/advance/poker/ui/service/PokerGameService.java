package com.advance.poker.ui.service;


import com.advance.poker.ui.dto.PokerGameDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.RemoteException;


@Service
public class PokerGameService {

    @Value("${com.advance.poker.backend.base.url}")
    private String baseUrl;

    private final static String SHUFFLE_DEAL_URI = "/poker/shuffle_and_deal/";
    public PokerGameDTO shuffleAndDeal(String numberOfPlayers) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(baseUrl + SHUFFLE_DEAL_URI +numberOfPlayers).newBuilder();


        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if(response.code() != 200){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                PokerGameDTO pokerGameDTO = objectMapper.readValue(response.body().string(), PokerGameDTO.class);
                if(pokerGameDTO.getErrorDTO() != null && pokerGameDTO.getErrorDTO().getMessage() != null) {
                    return pokerGameDTO;
                }
            }catch (Exception e){
            }
            throw new RemoteException("Service call return with error code \""+response.code() +"\" "+response.message());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        PokerGameDTO pokerGameDTO = objectMapper.readValue(response.body().string(), PokerGameDTO.class);
        return pokerGameDTO;
    }
}
