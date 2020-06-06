package com.web.controller;

import com.persistence.model.Game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * The end to end test can only be tested if the application is or by running all test together
 */


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class GameControllerEndToEndTest {

    private WebTestClient client;

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Test
    public void findAll(){
        this.client.get().uri("/game").exchange().expectStatus().isOk().expectBodyList(Game.class);
    }

    //TODO: sometimes error that no word was found
//    @Test
//    public void newGame(){
//        this.client.get().uri("/game/new").exchange().expectStatus().isOk().expectBodyList(Game.class);
//    }

    @Test
    public void runGameWithoutExistingGame(){
        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
        bodyBuilder.part("gameId", (long) 1);
        bodyBuilder.part("tryWord", "testen");

        this.client.post().uri("/game/run")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
                .exchange()
                .expectStatus().is5xxServerError();
    }

    //TODO: Test happy path 'run'

}


