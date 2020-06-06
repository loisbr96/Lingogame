package com.web.controller;

import com.persistence.model.Score;
import org.junit.Before;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest
public class ScoreControllerEndToEndTest {
    private WebTestClient client;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void findAll(){
        this.client.get().uri("/score").exchange().expectStatus().isOk().expectBodyList(Score.class);
    }

    //TODO: fix issue with finding a game
//    @Test
//    public void newScore(){
//        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
//        bodyBuilder.part("gameId", (long) 1);
//        bodyBuilder.part("username", "testuser");
//
//        this.client.post() .uri("/score/new")
//        .contentType(MediaType.MULTIPART_FORM_DATA)
//        .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
//        .exchange()
//        .expectStatus().isOk();
//    }

}
