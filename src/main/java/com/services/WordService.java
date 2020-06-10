package com.services;

import com.persistence.model.Game;
import com.persistence.model.Word;
import com.persistence.WordRepository;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordService{

    private final WordRepository wordRepository;

    private static Logger logger = LoggerFactory.getLogger(WordService.class);

    WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    public Word addWord(String wordString) throws Exception{
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(wordString);
        boolean find = matcher.find();
        if(find){
            logger.error(String.format("The following word contains forbidden characters: %s", wordString));
            throw new Exception("Er zijn geen speciale tekens of hoofdletters toegestaan");
        }

        if(wordString.length() < 5 || wordString.length() > 7){
            logger.error(String.format("The following word contains not the right number of characters: %s", wordString));
            throw new Exception("Het woord moet uit minimaal 5 en maximaal 7 letters bestaan");
        }
        Word word = new Word(wordString);
        return wordRepository.save(word);
    }

    public Optional<Word> findById(long id){
        return wordRepository.findById(id);
    }

    public Word getRandomWord() throws Exception {
        Iterable lengthIndex = wordRepository.findAll();
        long size = lengthIndex.spliterator().getExactSizeIfKnown() -1 ;
        long generatedLong = size + (long) (Math.random() * (0 - size));
        Optional<Word> word = wordRepository.findById(generatedLong);
        if (!word.isPresent()) {
            logger.error("No word was found");
            throw new Exception("No word was found");
        }
        return word.get();
    }

    public JSONArray feedbackWord(Game game, Word tryWord){
        Word word = game.getWord();
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < tryWord.getWord().length(); i++){
            char c = tryWord.getWord().charAt(i);

            JSONObject jsonObjectChar = new JSONObject();
            jsonObjectChar.put("char", c);
            jsonObjectChar.put("position", i);

            if(word.getWord().charAt(i) == c){
                jsonObjectChar.put("state", "correct");
            } else if(word.getWord().indexOf(c) != -1 ){
                jsonObjectChar.put("state", "contain");
            } else {
                jsonObjectChar.put("state", "wrong");
            }
            jsonArray.appendElement(jsonObjectChar);
        }
        return jsonArray;
    }
}
