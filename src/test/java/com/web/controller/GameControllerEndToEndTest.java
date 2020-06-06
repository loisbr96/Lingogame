package com.web.controller;

import com.persistence.model.Game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The end to end test can only be tested if the application is or by running all test together
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerEndToEndTest {

    private WebTestClient client;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void findAll(){
        this.client.get().uri("/game").exchange().expectStatus().isOk().expectBodyList(Game.class);
    }

    @Test
    public void newGame(){
        this.client.get().uri("/game/new").exchange().expectStatus().isOk();
    }

//    @Test
//    public void runGame(){
////        this.client.get().uri("/game/run").exchange().expectStatus().isOk();
//        LinkedMultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("gameId", "1");
//        formData.add("tryWord", "testen");
//
//        this.client.post().uri("/game/run").body(BodyInserters.fromFormData(formData))
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Map.class)
//                .consumeWith(result -> {
//                    Map map = result.getResponseBody();
//                    Map<String, Object> form = map getMap(map, "form");
//                    assertThat(form).containsEntry("gameId", 1);
//                    assertThat(form).containsEntry("tryWord", "testen");
//                });
//
//    }

}


