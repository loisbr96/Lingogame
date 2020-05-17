package com.web.controller;

import com.persistence.model.Word;
import com.persistence.model.WordRepository;
import com.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class WordController {
    private final WordRepository wordRepository;

    @Autowired
    private WordService wordService;

    @GetMapping("/")
    Iterable<Word> words(){
        return wordRepository.findAll();
    }

    @GetMapping("/id")
    public Optional<Word> getWordById(Long id){
        return wordRepository.findById(id);
    }

//    @GetMapping("/random")
//    public Word getRandomWord(){
//        return wordService.getRandomWord();
//    }
//
//    @GetMapping("/import")
//    public Word importWord(){
//        return wordService.importWord();
//    }

    WordController(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}

