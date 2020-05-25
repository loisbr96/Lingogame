package com.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.web.controller.WordController;

@SpringBootTest
public class WordControllerTest {

    @Autowired
    private WordController wordController;

    @Test
    public void contexLoads() throws Exception{
        assertThat(wordController).isNotNull();
    }
}
