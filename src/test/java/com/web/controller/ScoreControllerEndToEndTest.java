package com.web.controller;

import com.persistence.model.Score;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class ScoreControllerEndToEndTest {

    private WebTestClient client;

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
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
