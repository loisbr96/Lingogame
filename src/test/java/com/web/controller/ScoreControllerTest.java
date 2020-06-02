package com.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreControllerTest {

    @Autowired
    private ScoreController scoreController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(scoreController).isNotNull();
    }
}
