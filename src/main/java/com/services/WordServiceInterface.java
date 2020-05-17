package com.services;

import com.persistence.model.Word;

import java.util.List;

public interface WordServiceInterface {

    List<Word> allWords();

    Word getRandomWord();

    Word getWordById();

    Word importWord();

}
