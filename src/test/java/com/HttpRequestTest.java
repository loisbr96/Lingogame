package com;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpRequestTest {

    private WebTestClient client;

    @Before
    public void setUp(){
        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void applicationTest() {
        this.client.get().exchange().expectStatus().isOk();
    }
}
