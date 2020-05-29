package com.services;

import com.persistence.model.Game;
import com.persistence.model.Word;
import com.persistence.WordRepository;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordService{
    private final WordRepository wordRepository;

    public Word addWord(String wordString){
        Word word = new Word(wordString);
        return wordRepository.save(word);
    }

    public Optional<Word> findById(long id){
        return wordRepository.findById(id);
    }

    public Word getRandomWord() throws Exception {
        Iterable lengthIndex = wordRepository.findAll();
        long size = lengthIndex.spliterator().getExactSizeIfKnown() ;
        long generatedLong = size + (long) (Math.random() * (0 - size));
        Optional<Word> word = wordRepository.findById(generatedLong);
        if (!word.isPresent()) {
            throw new Exception("No word was found");
        }

        return word.get();
    }

    public JSONObject feedbackWord(Game game, Word tryWord){
        Word word = game.getWord();
        JSONObject jsonObjectWord = new JSONObject();
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
            jsonObjectWord.put("char", jsonObjectChar);
        }
        return jsonObjectWord;
    }

    WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}
