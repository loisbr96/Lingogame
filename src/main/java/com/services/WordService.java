package com.services;

import com.persistence.model.Word;
import com.persistence.WordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WordService{
    private final WordRepository wordRepository;

    public Iterable<Word> findAllWords(){
        return wordRepository.findAll();
    }

    public Word addWord(Word word){
        return wordRepository.save(word);
    }

    public Optional<Word> findWord(Long id){
        return wordRepository.findById(id);
    }

    WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}
