package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final WordService wordService;

    public Game newGame() throws Exception {
        Game game = new Game();
        game.setWord(wordService.getRandomWord());
        System.out.println(game);
        return game;
    }

    public boolean runRound(Game game, Word tryWord) throws Exception {
        if(game.hadEnded()){
            throw new Exception("The game has ended");
        }else{
            game.setRound(game.getRound() + 1);
        }
        if(tryWord.equals(game.getWord())){
            game.won();
        }
        if(!tryWord.equals(game.getWord()) && game.getRound() > 5){
            game.lost();
        }

        return tryWord.equals(game.getWord());
    }



    GameService(GameRepository gameRepository, WordService wordService){
        this.gameRepository = gameRepository;
        this.wordService = wordService;
    }



}
