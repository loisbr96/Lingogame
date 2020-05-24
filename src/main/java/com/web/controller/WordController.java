package com.web.controller;

import com.persistence.WordRepository;
import com.persistence.model.Word;
import com.services.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/word")
public class WordController {
    private final WordRepository wordRepository;
    private final WordService wordService;

    @GetMapping("")
    public @ResponseBody Iterable<Word> words(){
        return wordRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Word> getWordById(@PathVariable(value = "id") Long id){
        System.out.println(wordRepository.findById(id));
        return wordRepository.findById(id);
    }

    @RequestMapping("/add/{word}")
    public @ResponseBody Word addWord(@PathVariable(value = "word") String word){
        return wordService.addWord(word);
    }

    WordController(WordRepository wordRepository, WordService wordService){
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }
}

