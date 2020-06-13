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

    WordController(WordRepository wordRepository, WordService wordService){
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Word> words(){
        return wordRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Word> getWordById(@PathVariable(value = "id") Long id){
        return wordService.findById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Word addWord(@RequestParam(name = "word") String word) throws Exception{
        return wordService.addWord(word);
    }
//    @RequestMapping("/add/{word}")
//    public @ResponseBody Word addWord(@PathVariable(value = "word") String word)throws Exception{
//        return wordService.addWord(word);
//    }
}

