package com.web.controller;

import com.persistence.model.Word;
import com.services.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class WordController {
    private final WordService wordService;

//    @Autowired
//    private WordService wordService;

    @GetMapping("/")
    Iterable<Word> words(){
        return wordService.findAllWords();
    }

    @RequestMapping("/id/{id}")
    public @ResponseBody Optional<Word> getWordById(@PathVariable(value = "id") Long id){
        return wordService.findWord(id);
    }

    @RequestMapping("/add/{word}")
    public @ResponseBody Word addWord(@PathVariable(value = "word") Word word){
        return wordService.addWord(word);
    }

    WordController(WordService wordService){
        this.wordService = wordService;
    }
}

