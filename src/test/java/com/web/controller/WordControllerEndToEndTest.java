package com.web.controller;
import com.persistence.model.Word;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class WordControllerEndToEndTest {

    private WebTestClient client;

    @LocalServerPort
    private int port;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Test
    public void getAll() {
        this.client.get().uri("/word").exchange().expectStatus().isOk().expectBodyList(Word.class);
    }

    @Test
    public void getId(){
        this.client.get().uri("/word/1").exchange().expectStatus().isOk().expectBody(Word.class);
    }

    @Test
    public void addWord() {
        this.client.get().uri("/word/add/testen").exchange().expectStatus().isOk();
    }


}
