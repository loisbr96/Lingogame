package com.services;

import com.persistence.model.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WordService implements WordServiceInterface {
    @Override
    public ArrayList<Word> allWords() {
        return null;
    }

    @Override
    public Word getRandomWord() {
        return null;
    }

    @Override
    public Word getWordById() {
        return null;
    }

    @Override
    public Word importWord() {
        return null;
    }
}
