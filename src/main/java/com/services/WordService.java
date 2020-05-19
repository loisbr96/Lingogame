package com.services;

import com.persistence.model.Word;
import com.persistence.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class WordService{
    private final WordRepository wordRepository;

    public Word addWord(String wordString){
        Word word = new Word(wordString);
        return wordRepository.save(word);
    }


    WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}
