package com.web.controller;

import com.persistence.WordRepository;
import com.persistence.model.Word;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class WordController {
    private final WordRepository wordRepository;

//    @Autowired
//    private WordService wordService;

    @GetMapping("/")
    Iterable<Word> words(){
        return wordRepository.findAll();
    }

    @RequestMapping("/id/{id}")
    public @ResponseBody Optional<Word> getWordById(@PathVariable(value = "id") Long id){
        return wordRepository.findById(id);
    }

    @RequestMapping("/add/{word}")
    public @ResponseBody Word addWord(@PathVariable(value = "word") Word word){
        return wordRepository.save(word);
    }

    WordController(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}

