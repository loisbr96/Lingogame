package com.web.controller;

import com.persistence.WordRepository;
import com.persistence.model.Word;
import com.services.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/word")
public class WordController {
    private final WordRepository wordRepository;
    private final WordService wordService;

    private static Logger logger = LoggerFactory.getLogger(WordController.class);

    @GetMapping("")
    public @ResponseBody Iterable<Word> words(){
        return wordRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Word> getWordById(@PathVariable(value = "id") Long id){
        return wordService.findById(id);
    }

    @RequestMapping("/add/{word}")
    public @ResponseBody Word addWord(@PathVariable(value = "word") String word){
        return wordService.addWord(word);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public void handleError(Exception exception){
            logger.error(exception.getMessage());
    }

    WordController(WordRepository wordRepository, WordService wordService){
        this.wordRepository = wordRepository;
        this.wordService = wordService;
    }
}

