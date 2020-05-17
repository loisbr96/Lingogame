//package com.web.controller;
//
//import com.persistence.model.Word;
//import com.services.WordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//
//@RestController
//@RequestMapping("/word")
//public class WordController {
//
//    @Autowired
//    private WordService wordService;
//
//    @GetMapping(produces = {"application/hal+json"})
//    public ArrayList<Word> getAllWords(){
//        return wordService.allWords();
//    }
//
//    @GetMapping("/id")
//    public Word getWordById(){
//        return wordService.getWordById();
//    }
//
//    @GetMapping("/random")
//    public Word getRandomWord(){
//        return wordService.getRandomWord();
//    }
//
//    @GetMapping("import")
//    public Word importWord(){
//        return wordService.importWord();
//    }
//}
