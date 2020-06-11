package com.persistence;

import com.persistence.model.Word;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordUnitTest {
    @Test
    public void getWord(){
        Word word = new Word();
        word.setWord("testen");

        assertThat(word.getWord()).isEqualTo("testen");
    }

    @Test
    public void setWord(){
        Word word = new Word();
        word.setWord("testen");
        assertThat(word.getWord()).isEqualTo("testen");
    }


}
